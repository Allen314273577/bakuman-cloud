package cn.bakuman.provider.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @Author 梦叶
 */
@Slf4j
@RestController
@RequestMapping("provider")
public class ProviderController {

    @GetMapping("test")
    public ResponseEntity test() {
        log.info("provider执行");
        return ResponseEntity.ok(new Date());
    }
}
