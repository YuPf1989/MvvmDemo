package com.rain.mvvmdemo.db

import com.rain.mvvmdemo.data.db.PlaceDao
import com.rain.mvvmdemo.data.db.WeatherDao

/**
 * Author:rain
 * Date:2019/4/1 16:39
 * Description:
 */
object CoolWeatherDatabase {
    private var weatherDao: WeatherDao? = null
    private var placeDao: PlaceDao? = null
    fun getWeatherDao(): WeatherDao = if (weatherDao == null) WeatherDao() else weatherDao!!
    fun getPlaceDao(): PlaceDao = if (placeDao == null) PlaceDao() else placeDao!!
}