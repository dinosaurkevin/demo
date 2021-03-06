package com.example.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class Controller {
    private final Logger logger = Logger.getLogger(getClass());

    @Value("${aaa.bbb}")
    private String aaa;
    @Autowired
    private DiscoveryClient client;

    @RequestMapping("hello")
    public String hello(){
        return  aaa;
    }
    @RequestMapping(value = "/index", method= RequestMethod.GET)
    public String index(){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/hello, host:" + instance.getHost() + "，service id:" + instance.getServiceId());

        return "Hello World";
    }

}
