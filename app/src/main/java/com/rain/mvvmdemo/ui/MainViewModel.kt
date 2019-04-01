package com.rain.mvvmdemo.ui

import androidx.lifecycle.ViewModel
import com.rain.mvvmdemo.data.WeatherRepository

/**
 * Author:rain
 * Date:2019/3/26 15:49
 * Description:
 */
class MainViewModel(private val repository: WeatherRepository): ViewModel() {
    fun isWeatherCached() = repository.isWeatherCached()
}