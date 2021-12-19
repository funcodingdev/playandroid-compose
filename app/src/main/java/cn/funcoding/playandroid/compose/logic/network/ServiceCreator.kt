package cn.funcoding.playandroid.compose.logic.network

import cn.funcoding.playandroid.compose.AppContext
import com.franmontiel.persistentcookiejar.PersistentCookieJar
import com.franmontiel.persistentcookiejar.cache.SetCookieCache
import com.franmontiel.persistentcookiejar.persistence.SharedPrefsCookiePersistor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Retrofit创建类
 */
object ServiceCreator {
    private const val BASE_URL = "https://www.wanandroid.com"
    private val cookiePersistor = SharedPrefsCookiePersistor(AppContext)
    private val cookieJar = PersistentCookieJar(SetCookieCache(), cookiePersistor)

    fun clearCookie() = cookieJar.clear()

    fun hasCookie() = cookiePersistor.loadAll().isNotEmpty()

    private val okHttpClient: OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        .cookieJar(cookieJar)
        .build()

    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> create(serviceClass: Class<T>): T = retrofit.create(serviceClass)

    inline fun <reified T> create(): T = create(T::class.java)
}