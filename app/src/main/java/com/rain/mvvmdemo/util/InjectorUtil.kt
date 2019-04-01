package com.rain.mvvmdemo.util

import com.rain.mvvmdemo.data.PlaceRepository
import com.rain.mvvmdemo.data.WeatherRepository
import com.rain.mvvmdemo.data.network.CoolWeatherNetwork
import com.rain.mvvmdemo.db.CoolWeatherDatabase
import com.rain.mvvmdemo.ui.MainModelFactory
import com.rain.mvvmdemo.ui.area.ChooseAreaModelFactory

/**
 * Author:rain
 * Date:2019/4/1 16:30
 * Description:
 */
object InjectorUtil {

    private fun getPlaceRepository() = PlaceRepository.getInstance(CoolWeatherDatabase.getPlaceDao(), CoolWeatherNetwork.getInstance())

    private fun getWeatherRepository() = WeatherRepository.getInstance(CoolWeatherDatabase.getWeatherDao(), CoolWeatherNetwork.getInstance())

    fun getChooseAreaModelFactory() = ChooseAreaModelFactory(getPlaceRepository())

    fun getMainModelFactory() = MainModelFactory(getWeatherRepository())
}