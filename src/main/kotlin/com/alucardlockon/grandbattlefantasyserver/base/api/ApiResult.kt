package com.alucardlockon.grandbattlefantasyserver.base.api

class ApiResult() :HashMap<String,Any?>() {
    init{
        this["code"] = 200
        this["error"] = null
        this["data"] = null
    }
    constructor(value: Any?) : this() {
        this["data"] = value
    }

    constructor(key: String, value: Any?) : this() {
        chain(key, value)
    }

    constructor(error: Exception) : this() {
        error(error)
    }

    companion object fun chain(key: String, value: Any?): ApiResult {
        this[key] = value
        return this
    }

    fun error(error: Exception): ApiResult {
        this["error"] = error.message
        if (this["code"] == 200)
            this["code"] = 500
        return this
    }

    fun code(code: Int?): ApiResult {
        this["code"] = code
        return this
    }
}
