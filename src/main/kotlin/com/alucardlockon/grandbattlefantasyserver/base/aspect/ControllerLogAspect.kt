package com.alucardlockon.grandbattlefantasyserver.base.aspect

import org.aspectj.lang.annotation.AfterReturning
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import org.aspectj.lang.JoinPoint
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.*

/**
 * 记录控制器请求日志
 */
@Aspect
@Component
class WebLogAspect {

    private val logger = LoggerFactory.getLogger(javaClass.toString())

    @Pointcut("execution(public * com.alucardlockon.grandbattlefantasyserver..*Controller.*(..))")
    fun webLog() {
    }

    @Before("webLog()")
    @Throws(Throwable::class)
    fun doBefore(joinPoint: JoinPoint) {
        // 接收到请求，记录请求内容
        val attributes = RequestContextHolder.getRequestAttributes() as ServletRequestAttributes?
        val request = attributes!!.request

        // 记录下请求内容
        logger.info("==>  REQUEST URL : " + request.requestURL.toString()
                + ", HTTP_METHOD : " + request.method
                + ", CLASS_METHOD : " + joinPoint.signature.declaringTypeName + "." + joinPoint.signature.name
                + ", ARGS : " + Arrays.toString(joinPoint.args))
    }

    @AfterReturning(returning = "ret", pointcut = "webLog()")
    @Throws(Throwable::class)
    fun doAfterReturning(ret: Any) {
        // 处理完请求，返回内容
        logger.info("<==  RESPONSE : $ret")
    }

}