package com.example.demo;

import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HandleService {

    @Autowired
    DemoClient demoClient;

    @Autowired
    DemoClient2 demoClient2;

    @GlobalTransactional
    public void saveAll(){

        demoClient.tccSave();
        demoClient2.save();
    }


}
