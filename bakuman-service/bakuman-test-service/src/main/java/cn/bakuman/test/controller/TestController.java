package cn.bakuman.test.controller;

import cn.bakuman.test.properties.RefreshConfig;
import cn.bakuman.test.properties.ResfreshProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.concurrent.CompletableFuture;

/**
 * @Author 梦叶
 * @date 2021/12/3 15:08
 */
@RestController
@RequestMapping
@Slf4j
@RefreshScope
public class TestController {

    @Value(value = "${url:default}")
    private String url;

    @Autowired
    private ResfreshProperties resfreshProperties;

    @Autowired
    private RefreshConfig refreshConfig;

    @PostConstruct
    public void invoke() {
        CompletableFuture.runAsync(() -> {

            log.info(this.url);
            try {
                Thread.sleep(1000 * 2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    @GetMapping("refreshScope")
    public ResponseEntity<String> refreshScope() {
        System.out.println(resfreshProperties);
        System.out.println(refreshConfig);
        log.info(url);
        return ResponseEntity.ok(url);
    }
}
