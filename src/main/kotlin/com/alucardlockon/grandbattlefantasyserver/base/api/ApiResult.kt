package com.alucardlockon.grandbattlefantasyserver.base.api

data class ApiResult (
        var code: Int? = 200,
        var data: Any? = null,
        var error: String? = null
)