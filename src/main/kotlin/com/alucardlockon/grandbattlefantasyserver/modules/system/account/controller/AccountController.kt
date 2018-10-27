package com.alucardlockon.grandbattlefantasyserver.modules.system.account.controller

import com.alucardlockon.grandbattlefantasyserver.base.api.ApiResult
import com.alucardlockon.grandbattlefantasyserver.modules.system.account.entity.Account
import com.alucardlockon.grandbattlefantasyserver.modules.system.account.service.impl.AccountService
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCrypt
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/account")
class AccountController {
    @Autowired
    lateinit var service: AccountService

    @GetMapping("/")
    fun list(page: Page<Account>): ApiResult {
        return ApiResult(service.getById(1))
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int): ApiResult {
        return ApiResult(service.getById(id))
    }

    @PostMapping("/")
    fun post(@RequestBody account: Account): ApiResult {
        account.password = BCryptPasswordEncoder().encode(account.password)
        return ApiResult(service.save(account))
    }

    @PutMapping("/{id}")
    fun put(@PathVariable id: Int,@RequestBody account: Account): ApiResult {
        account.id = id
        return ApiResult(service.updateById(account))
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ApiResult {
        return ApiResult(service.removeById(id))
    }

    @PostMapping("/login")
    fun login(@RequestBody account: Account): ApiResult {
        println(BCryptPasswordEncoder().encode(account.password))
        return ApiResult(service.getOne(QueryWrapper<Account>(Account(username = account.username,password = BCryptPasswordEncoder().encode(account.password)))))
    }
}
