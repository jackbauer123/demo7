package com.example.demo;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.apache.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.stereotype.Component;

//@Component
public class OAuthFeignConfigs  {

    public static final String CLIENT_REGISTRATION_ID = "";


    public void apply(RequestTemplate template) {
        final String authorization = HttpHeaders.AUTHORIZATION;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication instanceof JwtAuthenticationToken){
            JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken)authentication;
            String tokenValue = jwtAuthenticationToken.getToken().getTokenValue();
            template.header("authorization", "Bearer "+tokenValue);
        }
        //HttpServletRequest  httpServletRequest = RequestContextUtils.
    }
}
