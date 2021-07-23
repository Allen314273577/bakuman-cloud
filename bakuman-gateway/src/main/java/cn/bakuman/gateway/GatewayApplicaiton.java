package cn.bakuman.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author 梦叶
 */
@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplicaiton {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplicaiton.class, args);
    }
}
