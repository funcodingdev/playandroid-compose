package cn.funcoding.playandroid.compose.ui.main.mine

import cn.funcoding.playandroid.compose.data.network.PlayAndroidApi

object AccountRepo {

    suspend fun login(username: String, password: String) =
        PlayAndroidApi.login(username, password)

    suspend fun register(username: String, password: String, repassword: String) =
        PlayAndroidApi.register(username, password, repassword)

    suspend fun logout() = PlayAndroidApi.logout()

}