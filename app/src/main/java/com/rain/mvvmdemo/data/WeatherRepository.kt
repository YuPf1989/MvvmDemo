package com.rain.mvvmdemo.data

import com.rain.mvvmdemo.data.db.WeatherDao
import com.rain.mvvmdemo.data.model.weather.Weather
import com.rain.mvvmdemo.data.network.CoolWeatherNetwork
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

/**
 * Author:rain
 * Date:2019/3/26 15:52
 * Description:
 */
class WeatherRepository private constructor(
    private val weatherDao: WeatherDao,
    private val network: CoolWeatherNetwork
) {
    fun isWeatherCached() = weatherDao.getCachedWeatherInfo() != null
    fun getCachedWeather() = weatherDao.getCachedWeatherInfo()!!

    suspend fun getWeather(weatherId: String, key: String): Weather {
        var weather = weatherDao.getCachedWeatherInfo()
        if (weather == null) weather = requestWeather(weatherId, key)
        return weather
    }

    private suspend fun requestWeather(weatherId: String, key: String) = withContext(Dispatchers.IO) {
        val heWeather = network.fetchWeather(weatherId, key)
        val weather = heWeather.weather!![0]
        weatherDao.cacheWeatherInfo(weather)
        weather
    }

    suspend fun refreshWeather(weatherId: String, key: String) = requestWeather(weatherId, key)

    suspend fun getBingPic(): String {
        var url = weatherDao.getCachedBingPic()
        if (url == null) url = requestBingPic()
        return url
    }

    suspend fun refreshBingPic() = requestBingPic()

    private suspend fun requestBingPic() = withContext(Dispatchers.IO) {
        val url = network.fetchBingPic()
        weatherDao.cacheBingPic(url)
        url
    }

    companion object {
        private var instance: WeatherRepository? = null
        fun getInstance(
            weatherDao: WeatherDao,
            network: CoolWeatherNetwork
        ):WeatherRepository {
            if (instance == null) {
                synchronized(WeatherRepository::class.java) {
                    if (instance == null) {
                        instance = WeatherRepository(weatherDao, network)
                    }
                }
            }
            return instance!!
        }
    }


}