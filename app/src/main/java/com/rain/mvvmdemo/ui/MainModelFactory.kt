package com.rain.mvvmdemo.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.rain.mvvmdemo.data.WeatherRepository

/**
 * Author:rain
 * Date:2019/4/1 16:25
 * Description:
 */
class MainModelFactory(private val repo:WeatherRepository):ViewModelProvider.NewInstanceFactory() {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MainViewModel(repo) as T
    }
}