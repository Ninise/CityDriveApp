package com.hazelhunt.citydriveapp.mvp.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.annotation.ColorRes
import android.support.annotation.IntegerRes
import android.support.annotation.StringRes
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity

/**
 * Created by ninise on 7/24/16.
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun integer(@IntegerRes res: Int): Int = resources.getInteger(res)

    fun string(@StringRes res: Int): String = resources.getString(res)

    fun color(@ColorRes res: Int): Int = resources.getColor(res)

    inline fun <reified T : Activity> Activity.navigate() {
        val intent = Intent(this, T::class.java)
        startActivity(intent)
    }

    fun <K> switchFragment(id: Int, fragment: Fragment) where K : Fragment {
        supportFragmentManager.beginTransaction().replace(id, fragment).commit()
    }

    fun <K> removeFragment(fragment: Fragment) where K : Fragment {
        supportFragmentManager.beginTransaction().remove(fragment).commit();
    }
}
