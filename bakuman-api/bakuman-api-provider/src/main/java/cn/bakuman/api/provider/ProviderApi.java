package cn.bakuman.api.provider;

import cn.bakuman.base.common.model.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author 梦叶
 */
public interface ProviderApi {
    @GetMapping("/provider/test")
    R<String> test(@RequestParam("str") String str);
}
