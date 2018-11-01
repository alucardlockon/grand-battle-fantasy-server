package com.alucardlockon.grandbattlefantasyserver.modules.game.player.mapper

import com.alucardlockon.grandbattlefantasyserver.modules.game.player.entity.Player
import com.baomidou.mybatisplus.core.mapper.BaseMapper
import org.apache.ibatis.annotations.Mapper

/**
 * 玩家账户 Mapper 接口
 *
 * @author alucardlockon
 * @since 2018-11-01
 */
@Mapper
interface PlayerMapper : BaseMapper<Player>
