package com.example.demo;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
public class Controller {
    private final Logger logger = Logger.getLogger(getClass());

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer",method = RequestMethod.GET)
    public String index(){
        return restTemplate.getForEntity("http://hello-service/hello",
                String.class) . getBody();
    }

}
