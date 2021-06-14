package br.com.criaproposta.demo.configuracaoseguranca;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;

@Configuration
@EnableWebSecurity
public class BasicConfiguration  extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.cors();
    	http.csrf().disable()
    	  .authorizeRequests()
    	  .antMatchers(HttpMethod.POST, "/propostas/**").permitAll() //.hasAuthority("SCOPE_profile")
    	  .antMatchers(HttpMethod.GET, "/detalheproposta/**").hasAuthority("SCOPE_profile")
    	  .antMatchers(HttpMethod.POST, "/cartao/**").permitAll()//hasAuthority("SCOPE_profile")
    	  .antMatchers(HttpMethod.GET, "/teste/**").permitAll()
    	  .antMatchers(HttpMethod.GET, "/actuator/prometheus/**").permitAll()
      	  .and()
       	  .sessionManagement()
      	  .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    	  .and()
    	  .oauth2ResourceServer()
    	   .jwt();
    	    
    }
}



