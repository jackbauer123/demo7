package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * A repository to manage {@link } instances.
 *
 * @author Greg Turnquist
 * @author Oliver Gierke
 */
@FeignClient(name = "service-provider")
public interface DemoClient {


    @RequestMapping(value = "/demo/saveall", method = GET)
    public String save();

    @RequestMapping(value = "/demo/testTcc", method = GET)
    public String  tccSave();



}