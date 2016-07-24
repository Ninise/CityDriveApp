package com.hazelhunt.citydriveapp.mvp.view.intro

import android.graphics.Color
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import com.github.paolorotolo.appintro.AppIntro2
import com.github.paolorotolo.appintro.AppIntro2Fragment
import com.github.paolorotolo.appintro.AppIntroFragment
import com.hazelhunt.citydriveapp.R

/**
 * Created by ninise on 7/24/16.
 */
class IntroActivity : AppIntro2() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        addSlide(AppIntroFragment.newInstance(
                getString(R.string.intro_first_title),
                getString(R.string.intro_first_desc),
                R.mipmap.ic_launcher,
                Color.parseColor("#3F51B5"))
        )

        addSlide(AppIntroFragment.newInstance(
                getString(R.string.intro_second_title),
                getString(R.string.intro_second_desc),
                R.mipmap.ic_launcher,
                Color.parseColor("#F9A825"))
        )

        addSlide(AppIntro2Fragment.newInstance(
                getString(R.string.intro_third_title),
                getString(R.string.intro_third_desc),
                R.mipmap.ic_launcher,
                Color.parseColor("#66BB6A"))
        )

        setDepthAnimation()
    }

    override fun onDonePressed(currentFragment: Fragment?) {
        super.onDonePressed(currentFragment)
        Log.d("das", "onDonePressed")
    }

    override fun onSkipPressed(currentFragment: Fragment?) {
        super.onSkipPressed(currentFragment)
        Log.d("das", "onSkipPressed")
    }
}