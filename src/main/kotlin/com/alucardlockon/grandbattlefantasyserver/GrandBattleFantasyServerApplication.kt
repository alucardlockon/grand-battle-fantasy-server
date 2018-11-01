package com.alucardlockon.grandbattlefantasyserver

import com.spring4all.swagger.EnableSwagger2Doc
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@EnableSwagger2Doc
@SpringBootApplication
class GrandBattleFantasyServerApplication

fun main(args: Array<String>) {
    runApplication<GrandBattleFantasyServerApplication>(*args)
}
