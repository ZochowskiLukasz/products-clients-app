package soft.dev.academy.customersorders.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import soft.dev.academy.customersorders.security.providers.DatabaseAuthenticationProvider;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DatabaseAuthenticationProvider authenticationProvider;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/customers/register", "/customers/activate").permitAll()
                .antMatchers("/customers/shouldBeLogged", "/customers/shouldBeLogged1")
                .authenticated()
                // other requests
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/customers/login")
                .loginProcessingUrl("/customers/login")
                .usernameParameter("login")
                .passwordParameter("password")
                .defaultSuccessUrl("/customers/shouldBeLogged")
                .permitAll()
                .and()
                // configure logout
                .logout()
                .permitAll();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);

    }
}
