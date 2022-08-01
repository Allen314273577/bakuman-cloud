package cn.bakuman.test.properties;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@RefreshScope
@Configuration
@Data
public class RefreshConfig {

    @Value("${test1.name1:''}")
    private String name1;
}
