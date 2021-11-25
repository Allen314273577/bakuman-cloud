package cn.bakuman.customer.controller;

import cn.bakuman.base.common.model.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Author 梦叶
 */
@Slf4j
@Api(tags = "消费者接口")
@RestController
@RequestMapping("customer")
public class CustomerController {

    @ApiOperation("feign调用传递header")
    @GetMapping("test")
    public R<String> test(@RequestParam("str") String str) {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = requestAttributes.getRequest();
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String header = request.getHeader(headerName);
            System.out.println("headerName = " + headerName);
            System.out.println("header = " + header);
        }
        log.info("customer执行");
        return R.success(str);
    }

}
