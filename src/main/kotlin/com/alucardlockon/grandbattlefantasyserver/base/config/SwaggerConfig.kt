package com.alucardlockon.grandbattlefantasyserver.base.config


import com.spring4all.swagger.EnableSwagger2Doc
import org.springframework.context.annotation.Configuration


@Configuration
@EnableSwagger2Doc
class SwaggerConfig {
    /*
    @Bean
    fun api(): Docket {
        return Docket(DocumentationType.SWAGGER_2).select().apis(
                RequestHandlerSelectors.basePackage("com.alucardlockon.grandbattlefantasyserver")).paths(PathSelectors.any()).build()
    }
    */
}