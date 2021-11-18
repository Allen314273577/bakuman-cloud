package cn.bakuman.provider;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

/**
 * @Author 梦叶
 */
@SpringCloudApplication
@EnableFeignClients
@Slf4j
@ComponentScan(basePackages = {"cn.bakuman","cn.bakuman.api"})
public class ProviderApplication {
    @Value("${spring.datasource.url}")
    private String DATASOURCE_URL;
    @Value("${spring.redis.host}")
    private String REDIS_HOST;
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(ProviderApplication.class, args);
        log.info("启动成功初始化了 {} 个Bean", run.getBeanDefinitionNames().length);
    }

    @PostConstruct
    public void init() {
        try {
            log.info("spring.datasource.url={}",DATASOURCE_URL);
            log.info("spring.redis.host={}",REDIS_HOST);
            log.info("初始化info", LocalDateTime.now());
            log.debug("初始化debug",LocalDateTime.now());
            log.trace("初始化trace",LocalDateTime.now());
            log.warn("初始化warn",LocalDateTime.now());
        } catch (Exception e) {
            log.error("初始化error",LocalDateTime.now());
        }
    }
}
