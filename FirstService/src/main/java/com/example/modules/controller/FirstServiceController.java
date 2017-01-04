package com.example.modules.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by admin on 2016/12/14.
 */
@RestController
public class FirstServiceController {

    private final Logger logger = Logger.getLogger(FirstServiceController.class);

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/say",method = RequestMethod.GET)
    public String sayHello(@RequestParam String name){
        ServiceInstance instance = client.getLocalServiceInstance();

        logger.info(name+ " say Hello to you \"");

        return "Hello!";
    }


}
