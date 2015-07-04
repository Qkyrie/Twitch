package com.deswaef.twitch.rest;

import org.springframework.web.client.RestTemplate;

/**
 * User: Quinten
 * Date: 19-9-2014
 * Time: 11:08
 *
 * @author Quinten De Swaef
 */
public class RestTemplateProvider {
     public RestTemplate rest() {
         return new RestTemplate();
     }
}
