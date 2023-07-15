package com.Learn.eduTrack.utils;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class BeanConfig {

	/*JDBC Credentials*/
	@Value("${dbConnection.driver}")
	private String jdbcDriver;
	
	@Value("${dbConnection.url}")
	private String dbUrl;
	
	@Value("${dbConnection.schema}")
	private String dbSchema;
	
	@Value("${dbConnection.username}")
	private String dbUserName;
	
	@Value("${dbConnection.password}")
	private String dbPassword;
	
	/*mailing Credentials*/
	@Value("${mail.host}")
	private String mailHost;

	@Value("${mail.port}")
	private String mailPort;
	
	@Value("${mail.userName}")
	private String mailUserName;
	
	@Value("${mail.password}")
	private String mailPassword;
	
	@Value("${mail.protocol}")
	private String mailProtocol;
	
	/* Beans */
	@Bean
    public DriverManagerDataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        
        dataSource.setDriverClassName(jdbcDriver);
        dataSource.setUrl(dbUrl+dbSchema);
        dataSource.setUsername(dbUserName);
        dataSource.setPassword(dbPassword);
        
        return dataSource;
    }
	
	@Bean 
	public JdbcTemplate jdbcTemplate (DriverManagerDataSource dataSource) {
		JdbcTemplate template = new JdbcTemplate (dataSource);
		return template;
	}
	
	@Bean
	public JavaMailSender getJavaMailSender() {
		int port = Integer.parseInt(mailPort);
	    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
	    
	    mailSender.setHost(mailHost);
	    mailSender.setPort(port);
	    mailSender.setUsername(mailUserName); 
	    mailSender.setPassword(mailPassword);
	    
	    Properties props = mailSender.getJavaMailProperties();
	    props.put("mail.transport.protocol", mailProtocol);
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.debug", "true");
	    
	    return mailSender;
	}

	@Bean 
	public InMemoryUserDetailsManager userDetailsManager() {
		
		UserDetails jack = User.builder()
				.username("jack")
				.password("{noop}luke")
				.roles("MANAGER")
				.build();
		
		UserDetails susan = User.builder()
				.username("susan")
				.password("{noop}luke")
				.roles("TEACHER")
				.build();

		UserDetails james = User.builder()
				.username("JAMES")
				.password("{noop}luke")
				.roles("STUDENT")
				.build();
		
		return new InMemoryUserDetailsManager(jack, susan, james);
	}
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests( configurer -> 
			configurer
				.requestMatchers(HttpMethod.POST, "/teacher/add").hasRole("MANAGER")
				.requestMatchers(HttpMethod.GET, "/teacher/test").hasRole("TEACHER")
		);
		http.httpBasic(Customizer.withDefaults());
		return http.build();
	}
}
