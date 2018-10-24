package com.alucardlockon.grandbattlefantasyserver.modules.system.account.controller

import com.alucardlockon.grandbattlefantasyserver.base.api.ApiResult
import com.alucardlockon.grandbattlefantasyserver.modules.system.account.entity.Account
import com.alucardlockon.grandbattlefantasyserver.modules.system.account.service.impl.AccountService
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/account")
class AccountController {
    @Autowired
    lateinit var service: AccountService

    @GetMapping("/")
    fun list(page: Page<Account>): ApiResult {
        return ApiResult(data = service.getById(1))
    }

    @GetMapping("/{id}")
    fun get(@PathVariable id: Int): ApiResult {
        return ApiResult()
    }

    @PostMapping("/{id}")
    fun post(@PathVariable id: Int, account: Account): ApiResult {
        return ApiResult()
    }

    @PutMapping("/{id}")
    fun put(@PathVariable id: Int): ApiResult {
        return ApiResult()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ApiResult {
        return ApiResult()
    }
}

