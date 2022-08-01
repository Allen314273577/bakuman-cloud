package cn.bakuman.provider.controller;

import cn.bakuman.base.common.model.R;
import cn.bakuman.provider.feign.CustmoerClient;
import cn.hutool.core.thread.ThreadUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @Author 梦叶
 */
@Api(tags = "提供者接口")
@Slf4j
@RestController
@RequestMapping("provider")
public class ProviderController {

    @Resource
    private CustmoerClient custmoerClient;

    @ApiOperation("测试接口")
    @GetMapping("test")
    public R<String> test(@RequestParam("str") String str) {
        try {
            CompletableFuture.runAsync(() -> {
                log.info("provider执行");
                ThreadUtil.sleep(1000 * 1);

            }).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return R.success(str);
    }
    @ApiOperation("测试feign接口")
    @GetMapping("testfeign")
    public R testfeign(@RequestParam("str") String str) {
        log.info("测试feign接口");
        R<String> test = custmoerClient.test(str);
        String body = test.getData();
        return R.success(body);
    }
}
