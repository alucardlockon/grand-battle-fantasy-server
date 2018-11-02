package com.alucardlockon.grandbattlefantasyserver.modules.system.account.controller

import com.alucardlockon.grandbattlefantasyserver.base.api.ApiResult
import com.alucardlockon.grandbattlefantasyserver.base.api.PagerInfo
import com.alucardlockon.grandbattlefantasyserver.modules.system.account.entity.Account
import com.alucardlockon.grandbattlefantasyserver.modules.system.account.service.impl.AccountService
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiParam
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.cache.CacheManager
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.web.bind.annotation.*
import javax.annotation.security.RolesAllowed

@Api(tags = ["帐户"])
@RestController
@RequestMapping("/account")
class AccountController {
    @Autowired
    lateinit var service: AccountService

    @Autowired
    lateinit var passwordEncoder: PasswordEncoder

    @ApiOperation("获取帐户列表")
    @GetMapping("/")
    fun list(@ApiParam("分页参数") pager: PagerInfo): ApiResult {
        val logger = LoggerFactory.getLogger(this.javaClass)
        val page = Page<Account>(pager.pageNumber, pager.pageSize)
        return ApiResult(service.page(page, QueryWrapper<Account>()))
    }

    @ApiOperation("获取帐户")
    @GetMapping("/{id}")
    fun get(@PathVariable id: Int): ApiResult {
        return ApiResult(service.getById(id))
    }

    @ApiOperation("新建帐户")
    @PostMapping("/")
    fun post(@RequestBody account: Account): ApiResult {
        account.password = passwordEncoder.encode(account.password)
        return ApiResult(service.save(account))
    }

    @ApiOperation("修改帐户")
    @PutMapping("/{id}")
    @RolesAllowed("ADMIN")
    fun put(@PathVariable id: Int,@RequestBody account: Account): ApiResult {
        account.id = id
        return ApiResult(service.updateById(account))
    }

    @ApiOperation("删除帐户")
    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Int): ApiResult {
        return ApiResult(service.removeById(id))
    }

    @ApiOperation("获取自己")
    @GetMapping("/self")
    fun get(): ApiResult {
        val username = SecurityContextHolder.getContext().authentication.name
        return ApiResult(service.getByUsername(username))
    }

    /*
    @PostMapping("/login")
    fun login(@RequestBody account: Account): ApiResult {
        println(BCryptPasswordEncoder().encode(account.password))
        return ApiResult(service.getOne(QueryWrapper<Account>(Account(username = account.username,password = BCryptPasswordEncoder().encode(account.password)))))
    }
    */
}
