package com.alucardlockon.grandbattlefantasyserver.modules.system.account.service.impl

import com.alucardlockon.grandbattlefantasyserver.modules.system.account.mapper.AccountMapper
import com.alucardlockon.grandbattlefantasyserver.modules.system.account.service.IAccountService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class AccountService : IAccountService {
    @Autowired
    lateinit var mapper: AccountMapper

    override fun getById(id:Int):Int {
        return mapper.getById(id)
    }
}