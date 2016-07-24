package com.hazelhunt.citydriveapp.mvp.view

import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.annotation.IntegerRes
import android.support.annotation.StringRes
import android.support.v7.app.AppCompatActivity

/**
 * Created by ninise on 7/24/16.
 */
class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun integer(@IntegerRes res: Int): Int = resources.getInteger(res)

    fun string(@StringRes res: Int): String = resources.getString(res)

    fun color(@ColorRes res: Int): Int = resources.getColor(res)
}
