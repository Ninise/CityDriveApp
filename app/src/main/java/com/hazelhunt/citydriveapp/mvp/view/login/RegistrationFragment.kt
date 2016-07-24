package com.hazelhunt.citydriveapp.mvp.view.login

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hazelhunt.citydriveapp.R
import com.hazelhunt.citydriveapp.extensions.inflate

/**
 * Created by ninise on 7/24/16.
 */
class RegistrationFragment : Fragment() {

    object instance {
        fun newInstance(): RegistrationFragment = RegistrationFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = container?.inflate(R.layout.registration_fragment)

        return view
    }

}