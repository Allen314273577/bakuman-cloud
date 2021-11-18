package cn.bakuman.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @Author 梦叶
 */
@SpringCloudApplication
public class GatewayApplicaiton {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplicaiton.class, args);
    }
}
