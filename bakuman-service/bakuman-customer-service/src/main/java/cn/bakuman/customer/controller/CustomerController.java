package cn.bakuman.customer.controller;

import cn.bakuman.base.common.model.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author 梦叶
 */
@Slf4j
@RestController
@RequestMapping("customer")
public class CustomerController {

    @GetMapping("test")
    public R<String> test(@RequestParam("str") String str) {
        log.info("customer执行");
        return R.success(str);
    }

}
