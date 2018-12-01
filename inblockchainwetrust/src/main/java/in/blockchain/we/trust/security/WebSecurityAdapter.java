package in.blockchain.we.trust.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
public class WebSecurityAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .antMatchers("/api**").permitAll()
                .anyRequest().permitAll()
                .and()
                .headers().frameOptions().disable()
                .and()
                .cors().disable();

        http.formLogin()
                .loginPage("/users/login")
                .failureHandler(
                        (req, resp, e) -> resp.sendError(HttpStatus.BAD_REQUEST.value(), "Username or password invalid"))
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/home")
                .permitAll();

        http.logout()
                .logoutUrl("/users/logout")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutSuccessUrl("/login")
                .permitAll();
    }


    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }
}
