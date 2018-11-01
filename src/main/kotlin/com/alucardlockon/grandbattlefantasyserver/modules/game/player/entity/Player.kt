package com.alucardlockon.grandbattlefantasyserver.modules.game.player.entity

import java.util.*
import com.baomidou.mybatisplus.annotation.TableName

/**
 * 玩家账户 数据类
 *
 * @author alucardlockon
 * @since 2018-11-01
 */
@TableName("player")
data class Player  (
        var id:  Int?,
        var accountId:  Int?,
        var playerCode:  Int?,
        var playerName:  Int?,
        var gem:  Int?,
        var gold:  Int?,
        var level:  Int?,
        var exp:  Int?,
        var isEnabled:  Boolean?,
        var createDate:  Date?,
        var createUser:  Int?,
        var updateDate:  Date?,
        var updateUser:  Int?
)