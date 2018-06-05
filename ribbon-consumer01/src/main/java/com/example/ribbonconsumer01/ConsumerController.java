package com.example.ribbonconsumer01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Class:
 * @Description:
 * @Author: haitaow(haitaow @ hpe.com)
 * @Date: 6/2/2018-6:14 PM.
 * @Version 1.0
 */
@RestController
public class ConsumerController {


    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/ribbon/testB")
    public String hello() {
        return restTemplate.getForEntity("http://eureka-provider/", String.class).getBody();
    }
}