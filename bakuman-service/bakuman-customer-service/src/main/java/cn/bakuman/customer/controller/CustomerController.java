package cn.bakuman.customer.controller;

import cn.bakuman.base.common.model.R;
import cn.bakuman.customer.feign.ProviderClient;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author 梦叶
 */
@Slf4j
@Api(tags = "消费者接口")
@RestController
@RequestMapping("customer")
public class CustomerController {

    @Resource
    private ProviderClient providerClient;

    @ApiOperation("feign调用传递header")
    @GetMapping("test")
    public R<String> test(@RequestParam("str") String str) {

        log.info("customer执行");
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                log.info("新线程执行"+Thread.currentThread().getName());
            },"线程"+i).start();
        }
        return R.success(str);
    }


    @ApiOperation("循环调用get")
    @GetMapping("get")
    public R<String> get(@RequestParam("str") String str) {
        for (int i = 0; i < 59; i++) {
            providerClient.test(str+i);
            log.info("[{}]调用了[{}]次",Thread.currentThread().getName(),i);
        }
        return R.success(str);
    }

}
