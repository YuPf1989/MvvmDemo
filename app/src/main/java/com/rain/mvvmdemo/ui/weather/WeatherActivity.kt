package com.rain.mvvmdemo.ui.weather

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProviders
import com.rain.mvvmdemo.R
import com.rain.mvvmdemo.databinding.ActivityWeatherBinding
import kotlinx.android.synthetic.main.activity_weather.*
import kotlinx.android.synthetic.main.title.*

/**
 * Author:rain
 * Date:2019/3/27 10:32
 * Description:
 */
class WeatherActivity : AppCompatActivity(), LifecycleOwner {
    val viewmodel by lazy {
        ViewModelProviders.of(this).get(WeatherViewModel::class.java)
    }

    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityWeatherBinding>(this, R.layout.activity_weather)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= 21) {
            val decorView = window.decorView
            decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            window.statusBarColor = Color.TRANSPARENT
        }
        binding.viewModel = viewmodel
        binding.resId = R.color.colorPrimary
        binding.lifecycleOwner = this
        viewmodel.weatherId = if (viewmodel.isWeatherCached()) viewmodel.getCachedWeather().basic.weatherId
        else intent.getStringExtra("weather_id")
        navButton.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }
        viewmodel.getWeather()
    }
}