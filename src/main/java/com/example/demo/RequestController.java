package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class RequestController {

    @Autowired
    HandleService handleService;

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String save() {
        handleService.saveAll();
        return "save all success.";
    }
}
