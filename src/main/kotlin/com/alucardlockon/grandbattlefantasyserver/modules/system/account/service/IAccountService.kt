package com.alucardlockon.grandbattlefantasyserver.modules.system.account.service

import com.alucardlockon.grandbattlefantasyserver.modules.system.account.entity.Account
import com.baomidou.mybatisplus.extension.service.IService

interface IAccountService: IService<Account> {
    fun getByUsername(username: String): Account?
}