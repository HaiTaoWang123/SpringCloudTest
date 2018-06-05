SpringCloud 学习Demo
1、服务注册中心
2、服务提供者
3、服务消费者
4、负载均衡

运行步骤：
1、eureka-service,启动服务注册中心；
2、eureka-service-provider01,启动服务提供者，在注册中心注册服务；
3、rribbon-consumer,启动服务消费者，消费服务；
4、启动多个服务提供者，注册多个服务，可实现负载均衡的效果。