package com.hjzgg.swaager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
 
import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
 
/**
 * 项目名称：apidoc
 */
@Configuration
@EnableSwagger
// Loads the spring beans required by the framework
public class MySwaggerConfig
{
 
    private SpringSwaggerConfig springSwaggerConfig;
 
    /**
     * Required to autowire SpringSwaggerConfig
     */
    @Autowired
    public void setSpringSwaggerConfig(SpringSwaggerConfig springSwaggerConfig)
    {
        this.springSwaggerConfig = springSwaggerConfig;
    }
 
    /**
     * Every SwaggerSpringMvcPlugin bean is picked up by the swagger-mvc
     * framework - allowing for multiple swagger groups i.e. same code base
     * multiple swagger resource listings.
     */
    @Bean
    public SwaggerSpringMvcPlugin customImplementation()
    {
        return new SwaggerSpringMvcPlugin(this.springSwaggerConfig).apiInfo(apiInfo()).includePatterns(".*?");
    }
 
    private ApiInfo apiInfo()
    {
        ApiInfo apiInfo = new ApiInfo(
                "auth util restful api",
                "swaager ui restful api",
                "",
                "2570230521@qq.com",
                "",
                "http://www.cnblogs.com/hujunzheng/");
        return apiInfo;
    }
}