package com.alucardlockon.grandbattlefantasyserver

import com.baomidou.mybatisplus.core.toolkit.StringPool
import com.baomidou.mybatisplus.generator.InjectionConfig
import com.baomidou.mybatisplus.generator.AutoGenerator
import com.baomidou.mybatisplus.generator.config.*
import com.baomidou.mybatisplus.generator.config.po.TableInfo
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy
import com.baomidou.mybatisplus.generator.engine.VelocityTemplateEngine
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest
class CodeGenerator {

    @Test
    fun main() {
        // 代码生成器
        val mpg = AutoGenerator()
        val tableName = "player"
        var packageName = "player"

        // 全局配置
        val gc = GlobalConfig()
        val projectPath = System.getProperty("user.dir")
        gc.outputDir = "$projectPath/src/main/kotlin"
        gc.author = "alucardlockon"
        gc.isOpen = false
        gc.isKotlin = true
        // gc.isFileOverride = true
        mpg.globalConfig = gc

        // 数据源配置
        val dsc = DataSourceConfig()
        dsc.url = "jdbc:mysql://localhost:3306/grandbf?useUnicode=true&useSSL=false&characterEncoding=utf8"
        // dsc.setSchemaName("public");
        dsc.driverName = "com.mysql.cj.jdbc.Driver"
        dsc.username = "root"
        dsc.password = "1234"
        mpg.dataSource = dsc

        // 包配置
        val pc = PackageConfig()
        pc.moduleName = packageName
        pc.parent = "com.alucardlockon.grandbattlefantasyserver.modules"
        mpg.packageInfo = pc

        // 自定义配置
        val cfg = object : InjectionConfig() {
            override fun initMap() {
                // to do nothing
            }
        }
        val focList = ArrayList<FileOutConfig>()
        focList.add(object : FileOutConfig("/templates/mapper.xml.vm") {
            override fun outputFile(tableInfo: TableInfo): String {
                // 自定义输入文件名称
                return (projectPath + "/src/main/resources/mapper/" + pc.moduleName
                        + "/" + tableInfo.entityName + "Mapper" + StringPool.DOT_XML)
            }
        })
        cfg.fileOutConfigList = focList
        mpg.cfg = cfg

        mpg.template = TemplateConfig().setXml(null)
                .setController("template/controller.kt.vm")
                .setEntityKt("template/entity.kt.vm")
                .setMapper("template/mapper.kt.vm")
                .setService("template/service.kt.vm")
                .setServiceImpl("template/serviceImpl.kt.vm")

        // 策略配置
        val strategy = StrategyConfig()
        strategy.naming = NamingStrategy.underline_to_camel
        strategy.columnNaming = NamingStrategy.underline_to_camel
        // strategy.superEntityClass = "com.baomidou.ant.common.BaseEntity"
        // strategy.isEntityLombokModel = true
        strategy.isRestControllerStyle = true
        // strategy.superControllerClass = "com.baomidou.ant.common.BaseController"
        strategy.setInclude(tableName)
        //strategy.setSuperEntityColumns("id")
        strategy.isControllerMappingHyphenStyle = true
        strategy.setTablePrefix(pc.moduleName + "_")
        mpg.strategy = strategy
        mpg.templateEngine = VelocityTemplateEngine()
        mpg.execute()
    }
}
