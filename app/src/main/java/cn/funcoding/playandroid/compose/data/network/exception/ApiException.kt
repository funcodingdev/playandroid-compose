package cn.funcoding.playandroid.compose.data.network.exception

import java.lang.RuntimeException

class ApiException(var errorCode: Int, var errorMsg: String) : RuntimeException()