package com.example.demo;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * A repository to manage {@link }s.
 *
 * @author Greg Turnquist
 * @author Oliver Gierke
 */
@FeignClient("service-provider2")
public interface DemoClient2  {



    @RequestMapping(value = "/demo2/save", method = GET)
    public String save();
}