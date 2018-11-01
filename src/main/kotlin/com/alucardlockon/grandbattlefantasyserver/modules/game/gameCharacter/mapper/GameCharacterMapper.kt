package com.alucardlockon.grandbattlefantasyserver.modules.game.gameCharacter.mapper

import com.alucardlockon.grandbattlefantasyserver.modules.game.gameCharacter.entity.GameCharacter
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper

/**
 * 游戏角色 Mapper 接口
 *
 * @author alucardlockon
 * @since 2018-11-01
 */
@Mapper
interface GameCharacterMapper : BaseMapper<GameCharacter>
