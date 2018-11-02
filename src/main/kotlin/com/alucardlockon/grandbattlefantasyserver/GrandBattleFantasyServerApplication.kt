package com.alucardlockon.grandbattlefantasyserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cache.annotation.EnableCaching

//@EnableSwagger2Doc
@EnableCaching
@SpringBootApplication
class GrandBattleFantasyServerApplication

fun main(args: Array<String>) {
    runApplication<GrandBattleFantasyServerApplication>(*args)
}
