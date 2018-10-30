package com.alucardlockon.grandbattlefantasyserver.base.config

import com.alucardlockon.grandbattlefantasyserver.modules.system.account.entity.Account
import com.fasterxml.jackson.databind.ObjectMapper
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.boot.configurationprocessor.json.JSONObject
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import org.springframework.security.web.util.matcher.AntPathRequestMatcher
import java.io.IOException
import java.util.*
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

internal class JWTLoginFilter() : UsernamePasswordAuthenticationFilter() {

    constructor(authenticationManager:AuthenticationManager) : this() {
        this.authenticationManager = authenticationManager
    }

    @Throws(AuthenticationException::class, IOException::class, ServletException::class)
    override fun attemptAuthentication(
            req: HttpServletRequest, res: HttpServletResponse): Authentication {

        // 返回一个验证令牌
        return authenticationManager.authenticate(
                UsernamePasswordAuthenticationToken(
                        req.getParameter("username"),
                        req.getParameter("password")
                )
        )
    }

    @Throws(IOException::class, ServletException::class)
    override fun successfulAuthentication(
            req: HttpServletRequest,
            res: HttpServletResponse, chain: FilterChain?,
            auth: Authentication) {
        val writer = res.writer
        val account: User = auth.principal as User
        val claims: HashMap<String, Any> = HashMap()
        claims.put("username", account.username!!)
        claims.put("roles",account.authorities!!)
        val token = Jwts.builder()
                .setSubject(account.username)
                .setClaims(claims)
                .setExpiration(Date(Date().time + 1000 * 60 * 60 * 24L))
                .signWith(SignatureAlgorithm.HS256, "SERECT_KEY")
                .compact()
        writer?.write("{\"success\":true,\"token\":\"$token\"}")
    }


    @Throws(IOException::class, ServletException::class)
    override fun unsuccessfulAuthentication(request: HttpServletRequest, response: HttpServletResponse, failed: AuthenticationException) {
        val writer = response.writer
        val message = "登录失败"
        writer?.write("{\"success\":false,\"message\":\"$message\"}")
    }
}