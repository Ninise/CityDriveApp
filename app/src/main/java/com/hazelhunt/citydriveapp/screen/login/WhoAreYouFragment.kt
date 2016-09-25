package com.hazelhunt.citydriveapp.screen.login

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hazelhunt.citydriveapp.R
import com.hazelhunt.citydriveapp.extensions.inflate
import com.hazelhunt.citydriveapp.mvp.view.BaseActivity
import com.hazelhunt.citydriveapp.screen.main.MainActivity

/**
 * Created by ninise on 8/14/16.
 */
class WhoAreYouFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = container?.inflate(R.layout.who_are_you_fragment)

        var mDriverButton = view?.findViewById(R.id.whoAreYouDriverButton)
        var mPassengerButton = view?.findViewById(R.id.whoAreYouPassengerButton)

        mDriverButton!!.setOnClickListener { (activity as BaseActivity).startActivity(Intent(context, MainActivity::class.java)) }
        mPassengerButton!!.setOnClickListener { (activity as BaseActivity).startActivity(Intent(context, MainActivity::class.java)) }


        return view
    }
}
