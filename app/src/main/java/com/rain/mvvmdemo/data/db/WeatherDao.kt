package com.rain.mvvmdemo.data.db

import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.rain.mvvmdemo.CoolWeatherApplication
import com.rain.mvvmdemo.data.model.weather.Weather

/**
 * Author:rain
 * Date:2019/3/26 16:16
 * Description:
 */
class WeatherDao{

    fun getCachedWeatherInfo(): Weather? {
        val weatherInfo = PreferenceManager.getDefaultSharedPreferences(CoolWeatherApplication.instance).getString("weather", null)
        if (weatherInfo != null) {
            return Gson().fromJson(weatherInfo, Weather::class.java)
        }
        return null
    }
    private fun SharedPreferences.edit(action: SharedPreferences.Editor.() -> Unit) {
        val editor = edit()
        action(editor)
        editor.apply()
    }

    fun cacheWeatherInfo(weather: Weather?) {
        if (weather == null) return
        PreferenceManager.getDefaultSharedPreferences(CoolWeatherApplication.instance).edit {
            val weatherInfo = Gson().toJson(weather)
            putString("weather", weatherInfo)
        }
    }

    fun cacheBingPic(bingPic: String?) {
        if (bingPic == null) return
        PreferenceManager.getDefaultSharedPreferences(CoolWeatherApplication.instance).edit {
            putString("bing_pic", bingPic)
        }
    }

    fun getCachedBingPic(): String? = PreferenceManager.getDefaultSharedPreferences(CoolWeatherApplication.instance).getString("bing_pic", null)

}