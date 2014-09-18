###Authorization

Before we can start doing protected calls to the service, which require authentication, we'll have to somehow implement a flow to get an access code from the server. This access code, along with several scopes will determine whether or not an end-user would like to authenticate towards your application using Twitch as its credential provider.

Below you can find an example using Spring Web MVC of how I did it. I might add this to the API in the future, but for now, you can just use this example.

	@Value("${twitch.clientId}")
    private String clientId;
	@Value("${twitch.redirectURI}")
	private String redirectURI;

    @RequestMapping(method = GET)
    public String index() {
        String redirectUrl = "https://api.twitch.tv/kraken/oauth2/authorize" +
                             "?response_type=code" +
                             "&client_id=" + clientId +
                             "&redirect_uri=" + redirectURI
                             "&scope=user_read+chat_login";
        return "redirect:" + redirectUrl;
    }

    @RequestMapping(value = "/oauth_redirect", method = GET)
    public String oauthRedirect(@RequestParam("code") String access_token, @RequestParam("scope") String scopes) {
        logger.info("access token: " + access_token);
        logger.info("scopes: " + scopes);
        //do something with the token, which can only be used once
        return "redirect:/";
    }