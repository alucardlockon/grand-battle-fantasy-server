package com.alucardlockon.grandbattlefantasyserver.modules.system.account.service.impl

import com.alucardlockon.grandbattlefantasyserver.modules.system.account.entity.Account
import com.alucardlockon.grandbattlefantasyserver.modules.system.account.mapper.AccountMapper
import com.alucardlockon.grandbattlefantasyserver.modules.system.account.service.IAccountService
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.cache.annotation.CacheConfig
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@CacheConfig(cacheNames = ["common"])
@Service
class AccountService : ServiceImpl<AccountMapper, Account>(), IAccountService {
    @Cacheable
    override fun getByUsername(username: String): Account? {
        return baseMapper.selectOne(QueryWrapper<Account>().eq("username",username))
    }
}