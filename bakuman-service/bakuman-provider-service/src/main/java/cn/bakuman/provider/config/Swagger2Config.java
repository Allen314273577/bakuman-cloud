package cn.bakuman.provider.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * <p>
 * swagger启用配置
 * </p>
 *
 * @author 番茄ICE
 * @since 2020/12/30
 * package: com.dedou.by.worker.config
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {


    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                // 自行修改为自己的包路径
                .apis(RequestHandlerSelectors.basePackage("cn.bakuman.provider.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("百应admin文档")
                .description("manage api 提供")
                // 服务条款网址
                .version("1.0")
                .contact(new Contact("ice", "http://blog.bakuman.cn", "314273577@qq.com"))
                .build();
    }

}
