package cn.funcoding.playandroid.compose.logic.network.exception

import java.lang.RuntimeException

class ApiException(var errorCode: Int, var errorMsg: String) : RuntimeException()