package com.alucardlockon.grandbattlefantasyserver.base.config

import io.jsonwebtoken.Jwts
import org.apache.commons.lang3.StringUtils
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.authority.AuthorityUtils
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter
import javax.servlet.ServletException
import java.io.IOException
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class TokenAuthorizationFilter(authenticationManager: AuthenticationManager?) : BasicAuthenticationFilter(authenticationManager) {
    private val HEADER_NAME = "Authorization"

    @Throws(IOException::class, ServletException::class)
    override fun doFilterInternal(request: HttpServletRequest, response: HttpServletResponse, chain: FilterChain) {
        val token = resolveToken(request)

        if(token != null) {
            val claims =  Jwts.parser().setSigningKey("SERECT_KEY").parseClaimsJws(token).body

            val authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(StringUtils.join(claims["roles"],","))

            SecurityContextHolder.getContext().authentication = UsernamePasswordAuthenticationToken(claims["username"], null, authorities)
        }

        chain.doFilter(request, response)
    }

    /**
     * 从请求头解析出token
     * @param request
     * @return token
     */
    private fun resolveToken(request: HttpServletRequest): String? {
        val token = request.getHeader(HEADER_NAME)
        return if (token == null || !token!!.startsWith("Bearer "))
            null
        else
            token.substring(7)
    }

}
