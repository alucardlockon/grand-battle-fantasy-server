package com.alucardlockon.grandbattlefantasyserver.modules.system.account.entity

import java.util.*

/**
 * 用户账户
 */
data class Account(
    val id:Int = 0,
    val username:String = "",
    val password:String = "",
    val email:String = "",
    val status:Int = 0,
    val createIp:String = "",
    val createDate:Date = Date(),
    val createUser:String = "",
    val updateDate:Date = Date(),
    val updateUser:String = "",
    val lastIp:String = ""
)