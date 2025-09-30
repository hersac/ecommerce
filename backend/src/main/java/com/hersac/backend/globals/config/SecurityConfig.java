package com.hersac.backend.globals.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.hersac.backend.modules.users.usuarios.models.Usuario;
import com.hersac.backend.modules.users.usuarios.models.repositories.UsuarioRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public UserDetailsService userDetailsService(UsuarioRepository usuarioRepository) {
		return email -> usuarioRepository.findByEmail(email)
			.map(Usuario::toUserDetails)
			.orElseThrow(() -> new UsernameNotFoundException("Usuario con email " + email + " no encontrado"));
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(csrf -> csrf.disable())
			.authorizeHttpRequests(
					auth -> auth.requestMatchers("/api/auth/**").permitAll().anyRequest().authenticated())
			.httpBasic(httpBasic -> {
			});

		return http.build();
	}

}
