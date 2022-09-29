package com.xiaoyi.base.config;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import springfox.bean.validators.configuration.BeanValidatorPluginsConfiguration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.List;

/**
 * @description: --
 * @author：Bing
 * @date：2022/3/26 21:49
 * @version：1.0
 */
@SuppressWarnings("ALL")
@Configuration//配置类
@EnableSwagger2 //swagger注解
@EnableKnife4j
@Import(BeanValidatorPluginsConfiguration.class) //knife4j需要引入
public class SwaggerConfig {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("接口api工具")
                .description("系统接口API工具")
                .version("1.0")
                .license("xxxx")
                .build();
    }

    @Bean(value = "defaultApi2")
    public Docket defaultApi2() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                //分组名称
                .groupName("2.X版本")
                .select()
                //这里指定Controller扫描包路径
                .apis(RequestHandlerSelectors.basePackage("com.xiaoyi.base"))
                .paths(PathSelectors.any())
                .build();
    }

    private List<RequestParameter> addHeader() {
        /*添加接口请求头参数配置 没有的话 可以忽略*/
        //RequestParameter tokenPar = new RequestParameter();
        //List<Parameter> pars = new ArrayList<>();
        //tokenPar.name("token").description("令牌").defaultValue("beibotest").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
        //pars.add(tokenPar.build());
        //return pars;
        return null;
    }
}
