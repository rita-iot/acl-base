package com.tx.base.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * springboot-swagger配置类
 */
@Configuration//配置类
@EnableSwagger2 //swagger注解
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class) //knife4j需要引入
public class SwaggerConfig {
    //@Bean
    //public Docket swaggerSpringMvcPlugin() {
    //    return new Docket(DocumentationType.SWAGGER_2)
    //            .apiInfo(apiInfo()).select()
    //            .apis(RequestHandlerSelectors
    //                    .withMethodAnnotation(ApiOperation.class))
    //            .build();
    //}
    //
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口api工具")
                .description("系统接口API工具")
                .version("1.0")  //版本
                .license("xxxx")//所有者
                .build();//构造
    }

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("2.X版本")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.tx.base.primary.controller"))
                .paths(PathSelectors.any())
                .build();
        return docket;
    }
}
