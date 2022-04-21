package com.greedy.jaegojaego.config;

import com.greedy.jaegojaego.authentification.model.service.AuthenticationService;
import com.greedy.jaegojaego.authentification.model.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.List;
import java.util.Map;

@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final AuthenticationService authenticationService;

    @Autowired
    SpringSecurityConfiguration(AuthenticationService authentificationService) {
        this.authenticationService = authentificationService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {

        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authenticationService).passwordEncoder(passwordEncoder());
    }

    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/**", "/js/**" , "/images/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        Map<String, List<String>> permitListMap = authenticationService.getPermitListMap();
        System.out.println("permitListMap = " + permitListMap);
        List<String> adminPermitList = permitListMap.get("adminPermitList");
        List<String> memberPermitList = permitListMap.get("memberPermitList");
        List<String> franchisePermitList = permitListMap.get("franchisePermitList");

        adminPermitList.forEach(url -> System.out.println("admin permit list : " + url));
        memberPermitList.forEach(url -> System.out.println("member permit list : " + url));

        http.csrf().disable()
                .authorizeHttpRequests()
                .antMatchers(memberPermitList.toArray(new String[memberPermitList.size()])).hasAnyRole("MEMBER", "ADMIN")
                .antMatchers(adminPermitList.toArray(new String[adminPermitList.size()])).hasRole("ADMIN")
                .antMatchers(franchisePermitList.toArray(new String[adminPermitList.size()])).hasRole("FRANCHISE")
                .anyRequest().permitAll()
            .and()
                .formLogin()
                .loginPage("/member/login")
                .successForwardUrl("/")
                .failureForwardUrl("/error/login")
            .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/member/logout"))
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .logoutSuccessUrl("/")
            .and()
                .exceptionHandling()
                .accessDeniedPage("/error/denied");
    }

}
