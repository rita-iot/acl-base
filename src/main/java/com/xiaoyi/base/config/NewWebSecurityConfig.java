package com.xiaoyi.base.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: --
 * @author：Bing
 * @date：2022/9/15 16:43
 * @version：1.0
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class NewWebSecurityConfig {
    @Autowired
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;
    @Autowired
    private AccessDeniedHandlerImpl accessDeniedHandler;
    @Autowired
    private UnauthEntryPointException unauthEntryPoint;
    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    //@Bean
    //public SecurityFilterChain securityFilterChain() throws Exception {
    //    List<Filter> filters = new ArrayList<>();
    //    return new DefaultSecurityFilterChain(new AntPathRequestMatcher("/**"), filters);
    //}

    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //关闭csrf
        http.csrf().disable()
                //关闭session
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                //.exceptionHandling().authenticationEntryPoint(new UnauthEntryPoint()).and()
                .authorizeRequests(auth ->
                        auth.antMatchers("/swagger-resources/**", "/v2/api-docs/**"
                                        , "/webjars/**", "/doc.html/**", "/admin/user/getVerificationCode",
                                        "/admin/user/getEasyCaptcha", "/websocket/**"
                                        , "/push/message/**", "/user/login", "/user/logout").permitAll()
                                .anyRequest().authenticated()
                )
                .httpBasic();
        //把jwt 过滤器 放在user过滤器之前
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
        //告诉security如何处理异常
        http.exceptionHandling().authenticationEntryPoint(unauthEntryPoint)
                .accessDeniedHandler(accessDeniedHandler);
        //允许跨域
        http.cors();
        return http.build();
    }

    /**
     * 配置加密方式
     * @return
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * 配置跨源访问(CORS)
     * @return
     */
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        CorsConfiguration corsConfiguration = new CorsConfiguration();

        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("GET");
        corsConfiguration.addAllowedMethod("POST");
        corsConfiguration.addAllowedMethod("PUT");
        corsConfiguration.addAllowedMethod("DELETE");
        corsConfiguration.setMaxAge(3600L);
        Map<String, CorsConfiguration> map = new HashMap<>(1);
        map.put("cors", corsConfiguration);
        source.setCorsConfigurations(map);
        return source;
    }
}
