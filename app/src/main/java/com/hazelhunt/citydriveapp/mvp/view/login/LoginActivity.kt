package com.hazelhunt.citydriveapp.mvp.view.login

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.hazelhunt.citydriveapp.R
import com.hazelhunt.citydriveapp.adapters.LoginViewPagerAdapter
import com.hazelhunt.citydriveapp.mvp.view.BaseActivity
import java.util.*

/**
 * Created by ninise on 7/24/16.
 */
class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val viewPager = findViewById(R.id.loginViewPager) as ViewPager?
        viewPager?.adapter = LoginViewPagerAdapter(supportFragmentManager, Arrays.asList(string(R.string.sign_in), string(R.string.sign_up)))

        val tabLayout = findViewById(R.id.loginTabLayout) as TabLayout?
        tabLayout?.setupWithViewPager(viewPager)
    }



}
