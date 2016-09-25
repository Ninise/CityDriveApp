package com.hazelhunt.citydriveapp.screen.main

import android.os.Bundle
import android.widget.Button
import com.hazelhunt.citydriveapp.R
import com.hazelhunt.citydriveapp.mvp.view.BaseActivity
import com.hazelhunt.citydriveapp.screen.map.MapFragment

/**
 * Created by ninise on 8/14/16.
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        var mapBtn : Button = findViewById(R.id.mainMapButton) as Button
        mapBtn.setOnClickListener { v -> switchFragment<MapFragment>(R.id.mapContainer, MapFragment()) }

    }
}
