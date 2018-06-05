package com.example.ribbonconsumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.CountDownLatch;

/**
 * @Class:
 * @Description:
 * @Author: haitaow(haitaow @ hpe.com)
 * @Date: 6/1/2018-10:39 AM.
 * @Version 1.0
 */
@RestController
public class ConsumerController {

    //服务消费者通过使用注解的方式修饰RestTemplate实现向服务的接口进行调用
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/ribbon/testA")
    public String hello() {
        return restTemplate.getForEntity("http://eureka-provider/", String.class).getBody();
    }
}
