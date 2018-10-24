package com.alucardlockon.grandbattlefantasyserver.base.config

import com.alucardlockon.grandbattlefantasyserver.base.api.ApiResult
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import javax.servlet.http.HttpServletRequest


@RestControllerAdvice
internal class GlobalExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun defaultErrorHandler(e: Exception): ApiResult {
        return ApiResult(null,e.message,200)
    }

}