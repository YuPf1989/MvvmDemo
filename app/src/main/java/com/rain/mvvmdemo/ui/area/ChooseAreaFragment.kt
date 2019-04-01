package com.rain.mvvmdemo.ui.area

import android.os.Bundle
import androidx.fragment.app.Fragment

/**
 * Author:rain
 * Date:2019/3/27 10:35
 * Description:
 */
class ChooseAreaFragment:Fragment() {
    companion object {
        const val LEVEL_PROVINCE = 0
        const val LEVEL_CITY = 1
        const val LEVEL_COUNTY = 2
        fun getInstance() = ChooseAreaFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }



}