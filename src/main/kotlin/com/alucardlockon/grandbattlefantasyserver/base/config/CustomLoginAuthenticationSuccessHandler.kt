package com.alucardlockon.grandbattlefantasyserver.base.config

import com.alucardlockon.grandbattlefantasyserver.modules.system.account.entity.Account
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.impl.crypto.MacProvider
import org.springframework.security.core.Authentication
import org.springframework.security.core.userdetails.User
import org.springframework.security.web.authentication.AuthenticationSuccessHandler
import org.springframework.stereotype.Service
import java.util.*
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Service
class CustomLoginAuthenticationSuccessHandler : AuthenticationSuccessHandler {
    override fun onAuthenticationSuccess(request: HttpServletRequest?, response: HttpServletResponse?, authentication: Authentication?) {
        val writer = response?.writer
        val account: User = authentication!!.principal as User
        val claims:HashMap<String,Any>  = HashMap()
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

}