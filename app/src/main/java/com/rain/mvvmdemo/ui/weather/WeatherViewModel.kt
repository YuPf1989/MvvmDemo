package com.rain.mvvmdemo.ui.weather

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.rain.mvvmdemo.CoolWeatherApplication
import com.rain.mvvmdemo.MainActivity
import com.rain.mvvmdemo.data.WeatherRepository
import com.rain.mvvmdemo.data.model.weather.Weather
import kotlinx.coroutines.launch

/**
 * Author:rain
 * Date:2019/3/27 11:30
 * Description:
 */
class WeatherViewModel(private val repository: WeatherRepository) : ViewModel() {
    var weather = MutableLiveData<Weather>()

    var bingPicUrl = MutableLiveData<String>()

    var refreshing = MutableLiveData<Boolean>()

    var weatherInitialized = MutableLiveData<Boolean>()

    var weatherId = ""

    private var key = MainActivity.KEY

    fun getWeather() {
        launch ({
            weather.value = repository.getWeather(weatherId, key)
            weatherInitialized.value = true
        }, {
            Toast.makeText(CoolWeatherApplication.instance, it.message, Toast.LENGTH_SHORT).show()
        })
        getBingPic(false)
    }

    private fun getBingPic(refresh: Boolean) {
        launch({
            bingPicUrl.value = if (refresh) repository.refreshBingPic() else repository.getBingPic()
        }, {
            Toast.makeText(CoolWeatherApplication.instance, it.message, Toast.LENGTH_SHORT).show()
        })
    }

    private fun launch(block: suspend () -> Unit, error: suspend (Throwable) -> Unit)=viewModelScope.launch{
        try {
            block()
        }catch (e:Throwable){
            error(e)
        }
    }

    fun onRefresh() {
        refreshWeather()
    }

    fun refreshWeather() {
        refreshing.value = true
        launch ({
            weather.value = repository.refreshWeather(weatherId, key)
            refreshing.value = false
            weatherInitialized.value = true
        }, {
            Toast.makeText(CoolWeatherApplication.instance, it.message, Toast.LENGTH_SHORT).show()
            refreshing.value = false
        })
        getBingPic(true)
    }

    fun isWeatherCached() = repository.isWeatherCached()

    fun getCachedWeather() = repository.getCachedWeather()

}