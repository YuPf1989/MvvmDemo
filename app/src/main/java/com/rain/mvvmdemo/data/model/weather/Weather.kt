package com.rain.mvvmdemo.data.model.weather

import com.google.gson.annotations.SerializedName

/**
 * Author:rain
 * Date:2019/3/27 8:51
 * Description:
 */
data class Weather(
    var status: String = "",
    var basic: Basic,
    var aqi: AQI,
    var now: Now,
    var suggestion: Suggestion,
    @SerializedName("daily_forecast")
    var forecastList: List<Forecast>
)