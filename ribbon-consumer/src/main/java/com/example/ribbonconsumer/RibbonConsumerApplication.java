package com.example.ribbonconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@EnableDiscoveryClient
@SpringBootApplication
public class RibbonConsumerApplication {

    //服务消费者通过使用注解的方式修饰RestTemplate实现向服务的接口进行调用
    // LoadBalancerAutoConfiguration--负载均衡拦截器设置给RestTemplate实例
    // RestTemplate可以通过注入的拦截器来构建相应的请求实现负载均衡。
    @LoadBalanced
    //增加了@LoanBalanced 注解后,实际上通过配置，为RestTemplate注入负载均衡拦截器，让负载均衡器选择根据其对应的策略选择合适的服务后，再发送请求。
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

    //使用RestTemplate进行Get、Post等各种请求，都是通过doExecute方法实现
    //createRequest方法实际是定义在HttpAccessor抽象类中。

    public static void main(String[] args) {
        SpringApplication.run(RibbonConsumerApplication.class, args);
    }
}
