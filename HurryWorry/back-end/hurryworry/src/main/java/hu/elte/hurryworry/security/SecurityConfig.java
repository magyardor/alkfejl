package hu.elte.hurryworry.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * This class implements the basic configuration of the application's security.
 *
 * @author eksztazidzsi
 */
@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * This service implements methods to handle the users actions.
     */
    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * This method configures the basic HTTP configuration.
     * @param http object that allows http configuration
     * @throws Exception if the configuration is invalid
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                /*
                 * Provides logout support.
                 * This is automatically applied when using WebSecurityConfigurerAdapter.
                 */
                .logout()
                /*
                 * The URL that triggers log out to occur (default is /logout).
                 * If CSRF protection is enabled (default), then the request must also be a POST.
                 */
                .logoutUrl("/logout")
                /*
                 * The URL to redirect to after logout has occurred.
                 * The default is /login?logout.
                 */
                .logoutSuccessUrl("/login")
                /*
                 * Specify whether to invalidate the HttpSession at the time of logout.
                 * This is true by default.
                 * Configures the SecurityContextLogoutHandler under the covers.
                 */
                .invalidateHttpSession(true)
                    .and()
                .cors()
                    .and()
                .csrf().disable()
                /*
                 * The "/register" url will be accessible
                 * without any authentication for HTTP POST requests.
                 * To reach any url (except "/register") users will
                 * need to authenticate.
                 */
                .authorizeRequests()
                    .antMatchers(HttpMethod.POST, "/register").permitAll()
                    .anyRequest().authenticated()
                    .and()
                .headers()
                    .frameOptions().disable()
                    .and()
                .httpBasic()
                    .authenticationEntryPoint(getBasicAuthEntryPoint())
                    .and()
                .sessionManagement()
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    /**
     * This method will handle and configure the authentication.
     * @param auth allows methods to easily build in memory authentication
     * @throws Exception if the configuration is invalid
     */
    @Autowired
    protected void configureAuthentication(AuthenticationManagerBuilder auth) throws Exception {
      auth
          .userDetailsService(userDetailsService)
          .passwordEncoder(passwordEncoder());
    }

    /**
     * This is a getter method for the encoder.
     * @return the BCryptPasswordEncoder object
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * This is a getter method for the authentication entry point.
     * @return the BasicEntryPoint object
     */
    @Bean
    public BasicEntryPoint getBasicAuthEntryPoint() {
        return new BasicEntryPoint();
    }
}
