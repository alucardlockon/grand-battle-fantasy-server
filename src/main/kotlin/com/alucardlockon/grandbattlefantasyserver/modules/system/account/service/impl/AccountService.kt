package com.alucardlockon.grandbattlefantasyserver.modules.system.account.service.impl

import com.alucardlockon.grandbattlefantasyserver.modules.system.account.entity.Account
import com.alucardlockon.grandbattlefantasyserver.modules.system.account.mapper.AccountMapper
import com.alucardlockon.grandbattlefantasyserver.modules.system.account.service.IAccountService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service

@Service
class AccountService : ServiceImpl<AccountMapper, Account>(), IAccountService {
}