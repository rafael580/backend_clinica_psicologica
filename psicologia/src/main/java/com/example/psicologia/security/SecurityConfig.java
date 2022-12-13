package com.example.psicologia.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    public void configure(HttpSecurity httpSec) throws Exception {
    // end point liberado
        httpSec.csrf().disable()
                .authorizeHttpRequests()

                // DASHBOARD

                .antMatchers(HttpMethod.GET,"/Dashborad/totalDeSessoes").permitAll()
                .antMatchers(HttpMethod.GET,"/Dashborad/sessoesdia").permitAll()
                .antMatchers(HttpMethod.GET,"/Dashborad/sessoesmes").permitAll()
                .antMatchers(HttpMethod.GET,"/Dashborad/sessoesmescanceladas").permitAll()
                .antMatchers(HttpMethod.GET,"/Dashborad/sessoesindividuaistotal").permitAll()
                .antMatchers(HttpMethod.GET,"/Dashborad/sessoesgrupototal").permitAll()
                .antMatchers(HttpMethod.GET,"/Dashborad/sessoesduplatotal").permitAll()

                // SESSAO

                .antMatchers(HttpMethod.GET,"/Dashborad/sessao").permitAll()
                .antMatchers(HttpMethod.GET,"/Dashborad/sessao/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/Dashborad/criarsessao/{cpf}").permitAll()
                .antMatchers(HttpMethod.PUT,"/Dashborad/{id}/{pacienteAtual}/{pacienteDestino}").permitAll()
                .antMatchers(HttpMethod.PUT,"/Dashborad/{id}/{idStatus}").permitAll()

                // PACIENTE

                .antMatchers(HttpMethod.GET,"/paciente").permitAll()
                .antMatchers(HttpMethod.GET,"/paciente/{id}").permitAll()
                .antMatchers(HttpMethod.POST,"/paciente").permitAll()
                .antMatchers(HttpMethod.PUT,"/paciente/{id}").permitAll()
                .antMatchers(HttpMethod.DELETE,"/paciente/{id}").permitAll();

	}
}
