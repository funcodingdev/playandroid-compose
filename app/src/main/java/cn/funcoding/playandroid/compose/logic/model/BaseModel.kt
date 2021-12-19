package cn.funcoding.playandroid.compose.logic.model

import cn.funcoding.playandroid.compose.logic.network.exception.ApiException

data class BaseModel<T>(
    private val `data`: T,
    val errorCode: Int,
    val errorMsg: String
) {
    fun apiModel(): T {
        if (errorCode == 0 && data != null) {
            return data
        } else {
            throw ApiException(errorCode, errorMsg)
        }
    }
}
