package com.alucardlockon.grandbattlefantasyserver.modules.game.gameCharacter.entity

import java.util.*
import com.baomidou.mybatisplus.annotation.TableName

/**
 * 游戏角色 数据类
 *
 * @author alucardlockon
 * @since 2018-11-01
 */
@TableName("game_character")
data class GameCharacter  (
        var id:  Int?,
        var characterName:  Int?,
        var hp:  Int?,
        var attack:  Int?,
        var defense:  Int?,
        var intel:  Int?,
        var resist:  Int?,
        var raceId:  Int?,
        var elementType:  Int?,
        var rarity:  Int?,
        var maxUpgradeStatus:  Int?,
        var maxHp:  Int?,
        var maxAttack:  Int?,
        var maxDefense:  Int?,
        var maxIntel:  Int?,
        var maxResist:  Int?,
        var createDate:  Date?,
        var createUser:  Int?,
        var updateDate:  Date?,
        var updateUser:  Int?
)