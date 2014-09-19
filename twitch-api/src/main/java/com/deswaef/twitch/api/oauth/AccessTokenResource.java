package com.deswaef.twitch.api.oauth;


import com.deswaef.twitch.api.oauth.domain.AccessTokenRequest;
import com.deswaef.twitch.api.oauth.domain.AccessTokenResponse;
import com.deswaef.twitch.rest.RestTemplateProvider;
import com.deswaef.twitch.api.APIResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * User: Quinten
 * Date: 16-9-2014
 * Time: 14:24
 *
 * @author Quinten De Swaef
 */
public class AccessTokenResource extends APIResource {

    private String oauthTokenUrl = "/oauth2/token";
    private String baseUrl;

    private AccessTokenRequest requestTemplate;

    public AccessTokenResource() {
        super();
        requestTemplate = new AccessTokenRequest();
    }

    public AccessTokenResource(RestTemplateProvider rtProvider) {
        super(rtProvider);
        requestTemplate = new AccessTokenRequest();
    }

    public AccessTokenResponse requestToken(String accessCode) {
        RestTemplate rest = rest();
        rest.getMessageConverters().add(new StringHttpMessageConverter());
        try {
            return rest.postForObject(
                    baseUrl + oauthTokenUrl,
                    requestTemplate.copy(accessCode),
                    AccessTokenResponse.class);
        } catch (HttpClientErrorException badRequestException) {
            if(badRequestException.getStatusCode().equals(HttpStatus.FORBIDDEN)) {
                return AccessTokenResponse.forbidden();
            }
            return AccessTokenResponse.invalid_code();
        } catch(Exception ex) {
            return AccessTokenResponse.unknown_issue();
        }
    }

    public AccessTokenResource setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        return this;
    }

    public AccessTokenResource setClientId(String clientId) {
        this.requestTemplate.setClient_id(clientId);
        return this;
    }


    public AccessTokenResource setClientSecret(String clientSecret) {
        this.requestTemplate.setClient_secret(clientSecret);
        return this;
    }


    public AccessTokenResource setRedirectUrl(String redirectUrl) {
        this.requestTemplate.setRedirect_uri(redirectUrl);
        return this;
    }
}
