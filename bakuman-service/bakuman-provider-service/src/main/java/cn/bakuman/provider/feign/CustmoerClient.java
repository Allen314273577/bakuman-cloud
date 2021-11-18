package cn.bakuman.provider.feign;

import cn.bakuman.api.customer.CustomerApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author 梦叶
 * @date 2021/11/10 16:32
 */
@FeignClient("bakuman-customer-service")
public interface CustmoerClient extends CustomerApi {
}
