package com.hazelhunt.citydriveapp.mvp.view.main

import android.os.Bundle
import com.hazelhunt.citydriveapp.R
import com.hazelhunt.citydriveapp.mvp.view.BaseActivity

/**
 * Created by ninise on 7/25/16.
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
    }
}