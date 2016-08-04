package cn.ms.mscrawler.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

/**
 * Created by weizheng on 2016/8/2.
 */
@Configuration
public class FileConfig {
    @Bean
    CommonsMultipartResolver commonsMultipartResolver(){
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(37546974);
        return multipartResolver;
    }
}
