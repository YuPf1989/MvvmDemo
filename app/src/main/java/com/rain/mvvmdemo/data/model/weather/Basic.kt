package com.rain.mvvmdemo.data.model.weather

import com.google.gson.annotations.SerializedName

/**
 * Author:rain
 * Date:2019/3/27 8:55
 * Description:
 */
data class Basic(
    @SerializedName("city")
    var cityName: String = "",
    @SerializedName("id")
    var weatherId: String = "",
    var update: Update
) {
    inner class Update {
        @SerializedName("loc")
        var updateTime = ""
        fun time() = updateTime.split(" ")[1]
    }
}

