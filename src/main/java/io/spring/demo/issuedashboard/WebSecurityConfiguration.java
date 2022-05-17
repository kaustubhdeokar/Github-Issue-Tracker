package io.spring.demo.issuedashboard;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final PasswordEncoder passwordEncoder;


    public WebSecurityConfiguration(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password(passwordEncoder.encode("verysecure"))
                .roles("USER")
                .and()
                .withUser("admin")
                .password(passwordEncoder.encode("evenmoresecure"))
                .roles("USER", "ADMIN");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() // <.>
                .antMatchers("/organisation/add").hasRole("ADMIN") // <.>
                .antMatchers("/project/add/*").hasRole("ADMIN") // <.>
                .and()
                .formLogin().permitAll() // <.>
                .and()
                .logout().permitAll(); // <.>
    }


}

