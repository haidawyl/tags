package org.hdwyl.tags.security;

import org.hdwyl.tags.domain.User;
import org.hdwyl.tags.service.impl.TagsUserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource
    private TagsUserDetailsService<User> tagsUserDetailsService;

    @Override
    protected void configure(HttpSecurity security) throws Exception {
        // 在SpringBoot中允许加载iframe
        security.headers().frameOptions().disable();
        security.csrf().disable()
                .authorizeRequests()
                .antMatchers("/error", "/logout", "/**/*.css", "/**/*.js", "/**/*.png", "/**/*.jpg", "/**/*.jpeg").permitAll()
                .antMatchers("/actuator/**").hasRole("ADMIN")
                .antMatchers("/**").hasAnyRole("USER", "ADMIN")
                .and()
                .formLogin()
                .loginPage("/login")
                .successForwardUrl("/")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(tagsUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }

}
