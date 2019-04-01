package com.rain.mvvmdemo

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.rain.mvvmdemo.ui.MainViewModel
import com.rain.mvvmdemo.ui.area.ChooseAreaFragment
import com.rain.mvvmdemo.ui.weather.WeatherActivity
import com.rain.mvvmdemo.util.InjectorUtil

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (KEY.isEmpty()) {
            AlertDialog.Builder(this)
                .setMessage("请先在MainActivity中配置天气API的Key")
                .setCancelable(false)
                .setPositiveButton("确定") { _, _ ->
                    finish()
                }
                .show()
        } else {
            val viewModel = ViewModelProviders.of(this,InjectorUtil.getMainModelFactory()).get(MainViewModel::class.java)
            if (viewModel.isWeatherCached()) {
                Intent(this, WeatherActivity::class.java).apply {
                    startActivity(this)
                    finish()
                }
            } else {
                supportFragmentManager.beginTransaction().replace(R.id.container,ChooseAreaFragment.getInstance()).commit()
            }
        }
    }

    companion object {
        // 备用Key，由于每个Key每天只有1000次免费请求，如果已用超的话请换别的Key使用。
        // 9da35b0a6b2c48498ed9e81b9d5206f3
        // 0099dcee07fd488e8b8866f16453fa2e
        const val KEY = "45dd25f63300445e967b461d2037e4f9"
    }
}
