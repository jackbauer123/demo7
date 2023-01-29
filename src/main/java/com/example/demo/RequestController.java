package com.example.demo;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class RequestController {

    @Autowired
    HandleService handleService;


    @GetMapping("/customer/show")
    public String index(/*@AuthenticationPrincipal Jwt jwt,*/ @RequestHeader Map<String,String> map) {
        map.forEach((k,v)-> System.out.println(k + "  " + v));
        return "success";
    }


    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String save( @RequestHeader Map<String,String> map) {
        map.forEach((k,v)-> System.out.println(k + "  " + v));
        handleService.saveAll();
        return "save all success.";
    }


    @RequestMapping(value = "/customer/encode/{password}", method = RequestMethod.GET)
    public String encoding(@PathVariable(name="password") String password){
        System.out.println("password:" + password);
        PasswordEncoder passwordEncoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return passwordEncoder.encode(password);
    }

//    @GetMapping("/resource")
//    public String resource(@AuthenticationPrincipal Jwt jwt) {
//        return String.format("Resource accessed by %s (sub)", jwt.getTokenValue());
//    }




    /*@Bean
    PreFlightRequestHandler getPerReq(){

        return new PreFlightRequestHandler(){
            @Override
            public Mono<Void> handlePreFlight(ServerWebExchange exchange) {
                System.out.println("==========================");
                System.out.println(exchange.getRequest().getHeaders());
                return null;
            }
        };
    }*/



}
