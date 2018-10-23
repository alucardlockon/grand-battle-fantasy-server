package com.alucardlockon.grandbattlefantasyserver.modules.system.account.controller

import com.alucardlockon.grandbattlefantasyserver.modules.system.account.entity.Account
import com.alucardlockon.grandbattlefantasyserver.modules.system.account.service.impl.AccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("account")
class AccountController {
    @Autowired
    lateinit var service: AccountService

    @GetMapping("read/{id}")
    fun read(@PathVariable("id") id: Int): Account {
        return Account(id = service.getById(id))
    }
}

