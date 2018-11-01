package com.alucardlockon.grandbattlefantasyserver.modules.game.player.service.impl

import com.alucardlockon.grandbattlefantasyserver.modules.game.player.entity.Player
import com.alucardlockon.grandbattlefantasyserver.modules.game.player.mapper.PlayerMapper
import com.alucardlockon.grandbattlefantasyserver.modules.game.player.service.IPlayerService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service

/**
 * 玩家账户 服务实现类
 *
 * @author alucardlockon
 * @since 2018-11-01
 */
@Service
open class PlayerServiceImpl : ServiceImpl<PlayerMapper, Player>(), IPlayerService {

}
