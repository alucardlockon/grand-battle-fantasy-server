package com.alucardlockon.grandbattlefantasyserver.modules.system.account.mapper

import org.apache.ibatis.annotations.Mapper
import org.springframework.stereotype.Repository

@Mapper
@Repository
class AccountMapper {
    fun getById(id: Int):Int {
        return id
    }
}