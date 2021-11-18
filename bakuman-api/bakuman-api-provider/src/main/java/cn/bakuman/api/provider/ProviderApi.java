package cn.bakuman.api.provider;

import cn.bakuman.base.common.model.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

/**
 * @Author 梦叶
 */
//@FeignClient("bakuman-provider-service")
public interface ProviderApi {
    @GetMapping("/provider/test")
    R<Date> test(@RequestParam("str") String str);
}
