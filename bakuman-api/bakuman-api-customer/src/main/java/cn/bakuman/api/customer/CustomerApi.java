package cn.bakuman.api.customer;

import cn.bakuman.base.common.model.R;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


public interface CustomerApi {
    /**
     * @see
     * @param str
     * @return
     */
    @GetMapping("customer/test")
    R<String> test(@RequestParam("str") String str);
}
