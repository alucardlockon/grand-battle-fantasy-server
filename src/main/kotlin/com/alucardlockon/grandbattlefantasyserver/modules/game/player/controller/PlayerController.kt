package com.alucardlockon.grandbattlefantasyserver.modules.game.player.controller

import com.alucardlockon.grandbattlefantasyserver.modules.game.player.entity.Player
import com.alucardlockon.grandbattlefantasyserver.modules.game.player.service.IPlayerService
import org.springframework.beans.factory.annotation.Autowired
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.springframework.web.bind.annotation.*
import com.alucardlockon.grandbattlefantasyserver.base.api.ApiResult
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import com.alucardlockon.grandbattlefantasyserver.base.api.PagerInfo
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper

/**
 * 玩家账户 控制器
 *
 * @author alucardlockon
 * @since 2018-11-01
 */
@Api(tags = ["玩家账户"])
@RestController
@RequestMapping("player")
class PlayerController{

    @Autowired
    lateinit var playerService: IPlayerService

    @ApiOperation("获取玩家账户列表")
    @GetMapping("/")
    fun list(@ApiParam("分页参数") pager: PagerInfo): ApiResult {
        val page = Page<Player>(pager.pageNumber, pager.pageSize)
        return ApiResult(playerService.page(page, QueryWrapper<Player>()))
    }

    @ApiOperation("获取玩家账户")
    @GetMapping("/{id}")
    fun get(@PathVariable id: Int): ApiResult {
        return ApiResult(playerService.getById(id))
    }

    @ApiOperation("创建玩家账户")
    @PostMapping("/")
    fun post(@RequestBody player:  Player): ApiResult {
        return ApiResult(playerService.save(player))
    }

    @ApiOperation("更新玩家账户")
    @PutMapping("/{id}")
    fun put(@PathVariable id: Int,@RequestBody player: Player): ApiResult {
        player.id = id
        return ApiResult(playerService.updateById(player))
    }

    @ApiOperation("删除玩家账户")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ApiResult {
        return ApiResult(playerService.removeById(id))
    }
}
