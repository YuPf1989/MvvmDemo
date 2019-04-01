package com.rain.mvvmdemo

import android.app.Application
import org.litepal.LitePal

/**
 * Author:rain
 * Date:2019/3/26 16:47
 * Description:
 */
class CoolWeatherApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        instance = this
        LitePal.initialize(this)
    }

    companion object {
        lateinit var instance:Application
    }

}