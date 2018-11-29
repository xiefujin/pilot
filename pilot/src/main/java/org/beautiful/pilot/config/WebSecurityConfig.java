package org.beautiful.pilot.config;

import org.beautiful.pilot.entity.User;
import org.beautiful.pilot.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Override
    protected void configure(HttpSecurity http) throws Exception { //配置策略
		 http.formLogin()                    //  定义当需要用户登录时候，转到的登录页面。
         .loginPage("/user/login")           // 设置登录页面
         .loginProcessingUrl("/user/dologin")  // 自定义的登录接口
         //.defaultSuccessUrl("/user/dologin")
         .and()
         .authorizeRequests()        // 定义哪些URL需要被保护、哪些不需要被保护
         .antMatchers("/user/login").permitAll()     // 设置所有人都可以访问登录页面
         .antMatchers("/user/register").permitAll()     // 设置所有人都可以访问登录页面
         .anyRequest()               // 任何请求,登录后可以访问
         .authenticated()
         .and()
         .csrf().disable();          // 关闭csrf防护
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
        auth.eraseCredentials(false);
    }

    @Bean
    public PasswordEncoder passwordEncoder() { //密码加密
        return new BCryptPasswordEncoder();
    }

//    @Bean
//    public LogoutSuccessHandler logoutSuccessHandler() { //登出处理
//        return new LogoutSuccessHandler() {
//            @Override
//            public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
//                try {
//                    SecurityUser user = (SecurityUser) authentication.getPrincipal();
//                    logger.info("USER : " + user.getUsername() + " LOGOUT SUCCESS !  ");
//                } catch (Exception e) {
//                    logger.info("LOGOUT EXCEPTION , e : " + e.getMessage());
//                }
//                httpServletResponse.sendRedirect("/login");
//            }
//        };
//    }
//
//    @Bean
//    public SavedRequestAwareAuthenticationSuccessHandler loginSuccessHandler() { //登入处理
//        return new SavedRequestAwareAuthenticationSuccessHandler() {
//            @Override
//            public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
//                User userDetails = (User) authentication.getPrincipal();
//                logger.info("USER : " + userDetails.getUsername() + " LOGIN SUCCESS !  ");
//                super.onAuthenticationSuccess(request, response, authentication);
//            }
//        };
//    }
//    @Bean
//    public UserDetailsService userDetailsService() {    //用户登录实现
//        return new UserDetailsService() {
//            @Autowired
//            private UserRepository userRepository;
//
//            @Override
//            public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
//                User user = userRepository.findOneByUsername(s);
//                if (user == null) throw new UsernameNotFoundException("Username " + s + " not found");
//                return new SecurityUser(user);
//            }
//        };
//    }
}
