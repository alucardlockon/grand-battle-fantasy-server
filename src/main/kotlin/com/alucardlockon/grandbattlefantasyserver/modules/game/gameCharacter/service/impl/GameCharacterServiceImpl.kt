package com.alucardlockon.grandbattlefantasyserver.modules.game.gameCharacter.service.impl

import com.alucardlockon.grandbattlefantasyserver.modules.game.gameCharacter.entity.GameCharacter
import com.alucardlockon.grandbattlefantasyserver.modules.game.gameCharacter.mapper.GameCharacterMapper
import com.alucardlockon.grandbattlefantasyserver.modules.game.gameCharacter.service.IGameCharacterService
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl
import org.springframework.stereotype.Service

/**
 * 游戏角色 服务实现类
 *
 * @author alucardlockon
 * @since 2018-11-01
 */
@Service
open class GameCharacterServiceImpl : ServiceImpl<GameCharacterMapper, GameCharacter>(), IGameCharacterService {

}
