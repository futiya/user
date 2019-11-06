package com.ibm.user.config;

//import com.ibm.login.services.UserService;
import com.ibm.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author Candise Li (jieqli@cn.ibm.com)
 * @create 2019-08-26 11:26
 */

@EnableWebSecurity
public class MySecurity extends WebSecurityConfigurerAdapter {
//    @Autowired
//    UserService service;
//    @Autowired
//    MyAuthenctiationFailureHandler myAuthenctiationFailureHandler;
    @Override
    protected void configure(final HttpSecurity http) throws Exception {
//        ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
//        myAuthenctiationFailureHandler.setDefaultFailureUrl("/login");
//        validateCodeFilter.setAuthenticationFailureHandler(myAuthenctiationFailureHandler);
//        // 将我们自定义的过滤器，配置到UsernamePasswordAuthenticationFilter之前
//        http.addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class) .formLogin();
        //  定义当需要用户登录时候，转到的登录页面。
        http
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login-error")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .and()
                .authorizeRequests().antMatchers("/login").permitAll()
                .and()
                .authorizeRequests()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403.html");
        http.csrf().disable();
        http.headers().frameOptions().disable();

    }

//    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
////        // auth.userDetailsService(service).passwordEncoder(new MyPasswordEncoder());
// //       auth.userDetailsService(service).passwordEncoder(new BCryptPasswordEncoder());
//
////        auth
////                .inMemoryAuthentication()
////                .passwordEncoder(new BCryptPasswordEncoder())
////                .withUser("jim").password(new BCryptPasswordEncoder().encode("demo")).roles("ADMIN").and()
////                .withUser("bob").password(new BCryptPasswordEncoder().encode("demo")).roles("USER").and()
////                .withUser("ted").password(new BCryptPasswordEncoder().encode("demo")).roles("USER","ROLE_ADMIN");
////    }
//
}
