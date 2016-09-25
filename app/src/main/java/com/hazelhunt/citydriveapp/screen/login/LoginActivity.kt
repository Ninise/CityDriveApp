package com.hazelhunt.citydriveapp.screen.login

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import com.hazelhunt.citydriveapp.R
import com.hazelhunt.citydriveapp.mvp.view.BaseActivity
import java.util.*

/**
 * Created by ninise on 7/24/16.
 */
class LoginActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        switchFragment<WhoAreYouFragment>(R.id.loginContainer, WhoAreYouFragment())
    }



}
