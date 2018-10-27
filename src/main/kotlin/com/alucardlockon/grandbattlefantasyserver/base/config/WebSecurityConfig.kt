package com.alucardlockon.grandbattlefantasyserver.base.config

import com.alucardlockon.grandbattlefantasyserver.modules.system.account.service.impl.AccountService
import com.google.common.collect.ImmutableList
import org.springframework.context.annotation.Bean
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import org.springframework.beans.factory.annotation.Autowired



@EnableWebSecurity
class WebSecurityConfig: WebSecurityConfigurerAdapter() {

    private var anyUserDetailsService: AnyUserDetailsService? = null

    @Autowired
    fun setAnyUserDetailsService(anyUserDetailsService: AnyUserDetailsService) {
        this.anyUserDetailsService = anyUserDetailsService
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        http
                .authorizeRequests()
                .anyRequest().permitAll()
                .and()
                .cors()
                .and()
                .csrf().ignoringAntMatchers("/**")
    }

    @Throws(Exception::class)
    override fun configure(auth: AuthenticationManagerBuilder?) {
        // auth.inMemoryAuthentication().passwordEncoder(BCryptPasswordEncoder())
        auth!!.userDetailsService<AnyUserDetailsService>(anyUserDetailsService)
                .passwordEncoder(BCryptPasswordEncoder())
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration()
        configuration.allowedOrigins = ImmutableList.of("*")
        configuration.allowedMethods = ImmutableList.of("HEAD",
                "GET", "POST", "PUT", "DELETE", "PATCH")
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }

}