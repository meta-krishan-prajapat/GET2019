package com.metacube.Student.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.metacube.Student.utils.UseDAO;

/**
 * @author krishan
 * Configuration Class
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{

	/**
	 *configure Authentication
	 */
	@Override
	protected void configure(final AuthenticationManagerBuilder auth) throws Exception
	{
		auth.jdbcAuthentication().dataSource(UseDAO.getInstance().getDataSource()).passwordEncoder(passwordEncoder())
				.usersByUsernameQuery("select username,password, enabled from users where username=?")
				.authoritiesByUsernameQuery("select username, role from user_roles where username=?");
	}

	/**
	 *configure security
	 */
	@Override
	protected void configure(final HttpSecurity http) throws Exception
	{
		http.authorizeRequests().antMatchers("/home").hasAuthority("USER").antMatchers("/showStudent").hasAuthority("ADMIN").and()
				.formLogin().loginPage("/login").defaultSuccessUrl("/home", true).failureUrl("/login?error=true").and().csrf().disable();
	}

	/**
	 * @return PasswordEncoder
	 */
	@Bean
	public PasswordEncoder passwordEncoder()
	{
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
}
