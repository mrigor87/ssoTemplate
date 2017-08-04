package mrigor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();




    @Autowired
    DataSource dataSource;

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {

        return super.authenticationManagerBean();
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception { // @formatter:off
        http
                .formLogin()
/*                .loginPage("/login")
                .usernameParameter("form-username")
                .passwordParameter("form-password")
                .loginProcessingUrl("/login.do")*/
                .permitAll()
                .and()
                .authorizeRequests().antMatchers("/me").authenticated()
                .and()
/*                .authorizeRequests().antMatchers("/login").permitAll()
                .and()*/
/*                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout.do"))
                .and()*/
                .requestMatchers().antMatchers("/login", "/oauth/authorize", "/oauth/confirm_access")
                .and()
                .authorizeRequests().anyRequest().authenticated();


/*        http.requestMatchers()
                .antMatchers("/login", "/oauth/authorize", "/*")
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .permitAll();*/
    } // @formatter:on

    // password encryptor
/*    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/

    @Bean
    JdbcUserDetailsManager jdbcUserDetailsManager(AuthenticationManagerBuilder auth,  DataSource dataSource) throws Exception {
        return auth.jdbcAuthentication().dataSource(dataSource).getUserDetailsService();
    }



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.jdbcAuthentication().getUserDetailsService();
        // @formatter:off
        auth.jdbcAuthentication()
           //     .passwordEncoder(passwordEncoder)
                .dataSource(dataSource)
                .withUser("john")
                .password("123").roles("USER")
                .and()
                .withUser("admin")
                .password("admin").roles("ADMIN");

//userService.test();

    } // @formatter:on

}
