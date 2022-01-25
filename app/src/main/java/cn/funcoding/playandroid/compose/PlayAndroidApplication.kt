package cn.funcoding.playandroid.compose

import android.app.Application
import android.content.ContextWrapper

private lateinit var INSTANCE: Application

class PlayAndroidApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}

object AppContext : ContextWrapper(INSTANCE)