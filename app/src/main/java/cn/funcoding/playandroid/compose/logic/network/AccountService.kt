package cn.funcoding.playandroid.compose.logic.network

import cn.funcoding.playandroid.compose.logic.model.BaseModel
import cn.funcoding.playandroid.compose.logic.model.LoginModel
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AccountService {

    /**
     * 登陆
     */
    @POST("user/login")
    suspend fun login(
        @Query("username") username: String,
        @Query("password") password: String
    ): BaseModel<LoginModel>


    /**
     * 注册
     */
    @POST("user/register")
    suspend fun register(
        @Query("username") username: String,
        @Query("password") password: String,
        @Query("repassword") repassword: String
    ): BaseModel<LoginModel>

    /**
     * 登出
     */
    @GET("user/logout/json")
    suspend fun logout(): BaseModel<Any>
}