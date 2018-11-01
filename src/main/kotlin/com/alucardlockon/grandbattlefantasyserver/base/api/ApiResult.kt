package com.alucardlockon.grandbattlefantasyserver.base.api

data class ApiResult(
        var data: HashMap<String, Any?>? = null,
        var error: String? = null,
        var code: Int? = 200
) {
    constructor(value: Any?) : this(HashMap(), null, 200) {
        this.data?.put("data", value)
    }

    constructor(key: String, value: Any?) : this(HashMap(), null, 200) {
        chain(key, value)
    }

    constructor(error: Exception) : this(HashMap(), null, 500) {
        error(error)
    }

    fun chain(key: String, value: Any?): ApiResult {
        this.data?.put(key, value)
        return this
    }

    fun error(error: Exception): ApiResult {
        this.error = error.message
        if (this.code == 200)
            this.code =  500
        return this
    }

    fun code(code: Int?): ApiResult {
        this.code = code
        return this
    }
}