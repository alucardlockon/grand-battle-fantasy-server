package com.alucardlockon.grandbattlefantasyserver.modules.system.account.controller

import com.alucardlockon.grandbattlefantasyserver.base.api.ApiResult
import com.alucardlockon.grandbattlefantasyserver.base.api.PagerInfo
import com.alucardlockon.grandbattlefantasyserver.modules.system.account.entity.Account
import com.alucardlockon.grandbattlefantasyserver.modules.system.account.service.impl.AccountService
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import javax.annotation.security.RolesAllowed

@RestController
@RequestMapping("/account")
class AccountController {
    @Autowired
    lateinit var service: AccountService

    @Autowired
    lateinit var passwordEncoder: PasswordEncoder

    @GetMapping("/")
    fun list(pager: PagerInfo): ApiResult {
        val page = Page<Account>(pager.pageNumber, pager.pageSize)
        return ApiResult(service.page(page, QueryWrapper<Account>()))
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int): ApiResult {
        return ApiResult(service.getById(id))
    }

    @PostMapping("/")
    fun post(@RequestBody account: Account): ApiResult {
        account.password = passwordEncoder.encode(account.password)
        return ApiResult(service.save(account))
    }

    @PutMapping("/{id}")
    @RolesAllowed("ADMIN")
    fun put(@PathVariable id: Int,@RequestBody account: Account): ApiResult {
        account.id = id
        return ApiResult(service.updateById(account))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ApiResult {
        return ApiResult(service.removeById(id))
    }

    @PostMapping("/test")
    fun test(@RequestBody anyThiny:String): ApiResult {
        return ApiResult(anyThiny)
    }

    @GetMapping("/self")
    fun get(): ApiResult {
        val username = SecurityContextHolder.getContext().authentication.name
        return ApiResult(service.getByUsername(username))
    }

    /*
    @PostMapping("/login")
    fun login(@RequestBody account: Account): ApiResult {
        println(BCryptPasswordEncoder().encode(account.password))
        return ApiResult(service.getOne(QueryWrapper<Account>(Account(username = account.username,password = BCryptPasswordEncoder().encode(account.password)))))
    }
    */
}
