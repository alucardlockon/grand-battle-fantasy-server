package com.alucardlockon.grandbattlefantasyserver.modules.system.account.mapper

import com.alucardlockon.grandbattlefantasyserver.modules.system.account.entity.Account
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper

@Mapper
interface AccountMapper: BaseMapper<Account> {

}