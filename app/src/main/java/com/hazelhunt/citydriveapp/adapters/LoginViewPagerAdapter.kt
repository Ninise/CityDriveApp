package com.hazelhunt.citydriveapp.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.hazelhunt.citydriveapp.mvp.view.login.LoginFragment
import com.hazelhunt.citydriveapp.mvp.view.login.RegistrationFragment

/**
 * Created by ninise on 7/24/16.
 */
class LoginViewPagerAdapter(fragmentManager: FragmentManager, asList: MutableList<String>) : FragmentPagerAdapter(fragmentManager) {

    val countOfPage = 2
    val list = asList

    override fun getItem(position: Int): Fragment {
        if (position == 0)
            return LoginFragment.instance.newInstance()
        else
            return RegistrationFragment.instance.newInstance()
    }

    override fun getCount(): Int = countOfPage

    override fun getPageTitle(position: Int): CharSequence {
        return list[position]
    }

}