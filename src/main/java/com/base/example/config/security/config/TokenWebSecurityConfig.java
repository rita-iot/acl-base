package com.base.example.config.security.config;

import com.base.example.config.security.filter.TokenAuthFilter;
import com.base.example.config.security.filter.TokenLoginFilter;
import com.base.example.config.security.security.DefaultPasswordEncoder;
import com.base.example.config.security.security.TokenLogoutHandler;
import com.base.example.config.security.security.TokenManager;
import com.base.example.config.security.security.UnauthEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/**
 * @description: --Security核心配置类
 * @author：Bing
 * @date：2021/12/1 16:51
 * @version：1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class TokenWebSecurityConfig extends WebSecurityConfigurerAdapter {

    private TokenManager tokenManager;
    private RedisTemplate redisTemplate;
    private DefaultPasswordEncoder defaultPasswordEncoder;
    private UserDetailsService userDetailsService;
    //使用BC加密
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /**
     * 使用 自定义密码加密类
     * @param userDetailsService
     * @param defaultPasswordEncoder
     * @param tokenManager
     * @param redisTemplate
     */
    //@Autowired
    //public TokenWebSecurityConfig(UserDetailsService userDetailsService, com.tx.base.security.security.DefaultPasswordEncoder defaultPasswordEncoder,
    //                              com.tx.base.security.security.TokenManager tokenManager, RedisTemplate redisTemplate) {
    //    this.userDetailsService = userDetailsService;
    //    this.defaultPasswordEncoder = defaultPasswordEncoder;
    //    this.tokenManager = tokenManager;
    //    this.redisTemplate = redisTemplate;
    //}
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;


    /**
     * 配置使用认证的类
     * @param userDetailsService    自定义UserService
     * @param bCryptPasswordEncoder 自定义密码加密器
     * @param tokenManager          自定义token管理器
     * @param redisTemplate         自定义redis管理器
     */
    @Autowired
    public TokenWebSecurityConfig(UserDetailsService userDetailsService, BCryptPasswordEncoder bCryptPasswordEncoder,
                                  TokenManager tokenManager, RedisTemplate redisTemplate) {
        this.userDetailsService = userDetailsService;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.tokenManager = tokenManager;
        this.redisTemplate = redisTemplate;
    }

    /**
     * 配置设置
     * @param http
     * @throws Exception
     */
    //设置退出的地址和token，redis操作地址
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling()
                .authenticationEntryPoint(new UnauthEntryPoint())//没有权限访问
                .and().csrf().disable()
                .authorizeRequests()
                //.anyRequest().permitAll()
                .anyRequest().authenticated()
                //.and().formLogin().loginProcessingUrl("/index/login")
                .and().logout().logoutUrl("/admin/logout")//退出路径
                .addLogoutHandler(new TokenLogoutHandler(tokenManager, redisTemplate))
                .and()
                .addFilter(new TokenLoginFilter(authenticationManager(), tokenManager, redisTemplate))//添加自定义过滤器
                .addFilter(new TokenAuthFilter(authenticationManager(), tokenManager, redisTemplate))
                .httpBasic();
    }

    /**
     * 调用userDetailsService和密码处理
     * @param auth
     * @throws Exception
     */
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(bCryptPasswordEncoder);
    }

    /**
     *
     * 不进行认证的路径，可以直接访问
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/swagger-resources", "/v2/api-docs", "/webjars/**",
                "/doc.html", "/admin/user/getVerificationCode", "/admin/user/getEasyCaptcha","/websocket/**","/test/**"
                ,"/push/message/**");
    }
}
