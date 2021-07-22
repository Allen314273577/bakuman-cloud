package cn.bakuman.test;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.net.NetUtil;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;

/**
 * @Author 梦叶
 */
@Slf4j
@EnableTransactionManagement
@EnableDiscoveryClient
@EnableFeignClients
@SpringBootApplication
public class TestApplication {
    @Value("${spring.profiles.active}")
    private String active;

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(TestApplication.class, args);
        WebServer webServer = ((AnnotationConfigServletWebServerApplicationContext) run).getWebServer();
        log.info("Service Startup success：http://{}:{}", NetUtil.localIpv4s().iterator().next(), webServer.getPort());
        log.info("Spring boot 启动初始化了 {} 个 Bean", run.getBeanDefinitionNames().length);
    }

    @PostConstruct
    private void init() {
        try {
            log.info("初始化logback打印info：{}", LocalDateTime.now());
            log.debug("初始化logback打印debug：{}", LocalDateTime.now());
            log.trace("初始化logback打印trace：{}", LocalDateTime.now());
            log.warn("初始化logback打印warn：{}", LocalDateTime.now());
            log.error("初始化logback打印error：{}", LocalDateTime.now());
            MDC.put("localIp", NetUtil.getLocalhostStr());
            log.info("#初始化YML环境 [{}]操作时间[{}]", active, DateUtil.now());
        } catch (Exception e) {
            log.error("#初始化配置错误！");
        }
    }
}
