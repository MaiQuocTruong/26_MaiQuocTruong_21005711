package fit.iuh.se.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import fit.iuh.se.services.impl.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(auth -> auth.requestMatchers("/sinhvien/add-sinhvien", "/sinhvien/save", "/sinhvien/edit-sinhvien/**", "/sinhvien/delete/**").hasRole("ADMIN")
				.requestMatchers("/sinhvien/**").hasAnyRole("ADMIN", "USER").anyRequest().permitAll())
				.formLogin(form -> form.loginProcessingUrl("/login").defaultSuccessUrl("/sinhvien", true).permitAll())
				.logout(logout -> logout.permitAll());
		return http.build();
	}
	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(customUserDetailsService);
		provider.setPasswordEncoder(passwordEncoder());
		return new ProviderManager(provider);
	}
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
