package com.alucardlockon.grandbattlefantasyserver.modules.system.account.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("account")
class AccountController {
    @GetMapping("read")
    fun read () :String {
        return "123"
    }
}

