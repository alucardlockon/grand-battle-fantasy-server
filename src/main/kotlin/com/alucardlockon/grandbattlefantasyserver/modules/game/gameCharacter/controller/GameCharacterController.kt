package com.alucardlockon.grandbattlefantasyserver.modules.game.gameCharacter.controller

import com.alucardlockon.grandbattlefantasyserver.modules.game.gameCharacter.entity.GameCharacter
import com.alucardlockon.grandbattlefantasyserver.modules.game.gameCharacter.service.IGameCharacterService
import org.springframework.beans.factory.annotation.Autowired
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.springframework.web.bind.annotation.*
import com.alucardlockon.grandbattlefantasyserver.base.api.ApiResult
import com.alucardlockon.grandbattlefantasyserver.base.api.PagerInfo
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam

/**
 * 游戏角色 控制器
 *
 * @author alucardlockon
 * @since 2018-11-01
 */
@Api(tags = ["游戏角色"])
@RestController
@RequestMapping("gameCharacter")
class GameCharacterController{

    @Autowired
    lateinit var gameCharacterService: IGameCharacterService

    @ApiOperation("获取游戏角色列表")
    @GetMapping("/")
    fun list(@ApiParam("分页参数") pager: PagerInfo): ApiResult {
        val page = Page<GameCharacter>(pager.pageNumber, pager.pageSize)
        return ApiResult(gameCharacterService.getById(1))
    }

    @ApiOperation("获取游戏角色")
    @GetMapping("/{id}")
    fun get(@PathVariable id: Int): ApiResult {
        return ApiResult(gameCharacterService.getById(id))
    }

    @ApiOperation("创建游戏角色")
    @PostMapping("/")
    fun post(@RequestBody gameCharacter:  GameCharacter): ApiResult {
        return ApiResult(gameCharacterService.save(gameCharacter))
    }

    @ApiOperation("更新游戏角色")
    @PutMapping("/{id}")
    fun put(@PathVariable id: Int,@RequestBody gameCharacter: GameCharacter): ApiResult {
        gameCharacter.id = id
        return ApiResult(gameCharacterService.updateById(gameCharacter))
    }

    @ApiOperation("删除游戏角色")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ApiResult {
        return ApiResult(gameCharacterService.removeById(id))
    }
}
