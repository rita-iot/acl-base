package com.xiaoyi.base.config.security.config;

import com.xiaoyi.base.config.security.filter.JwtAuthenticationTokenFilter;
import com.xiaoyi.base.config.security.security.JwtTokenManager;
import com.xiaoyi.base.config.security.security.UnauthEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
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
    private JwtTokenManager jwtTokenManager;
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;
    @Autowired
    private AuthenticationConfiguration authenticationConfiguration;

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    //@Bean
    //public SecurityFilterChain securityFilterChain() throws Exception {
    //    List<Filter> filters = new ArrayList<>();
    //    return new DefaultSecurityFilterChain(new AntPathRequestMatcher("/**"), filters);
    //}

    //配置过滤
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()//关闭csrf
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)//关闭session
                .and()
                .exceptionHandling().authenticationEntryPoint(new UnauthEntryPoint()).and()
                .authorizeRequests(auth ->
                        auth.antMatchers("/swagger-resources/**", "/v2/api-docs/**"
                                        , "/webjars/**", "/doc.html/**", "/admin/user/getVerificationCode",
                                        "/admin/user/getEasyCaptcha", "/websocket/**"
                                        , "/push/message/**", "/user/login").permitAll()
                                .anyRequest().authenticated()
                )
                .httpBasic();
        http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
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
        Map<String, CorsConfiguration> map = new HashMap<>();
        map.put("cors", corsConfiguration);
        source.setCorsConfigurations(map);
        return source;
    }
}
