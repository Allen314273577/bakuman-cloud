package cn.bakuman.customer.feign;

import cn.bakuman.api.provider.ProviderApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Author 梦叶
 * @date 2021/11/10 16:32
 */
@FeignClient("bakuman-provider-service")
public interface ProviderClient extends ProviderApi {
}
