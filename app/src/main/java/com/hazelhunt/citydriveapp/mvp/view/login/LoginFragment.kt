package com.hazelhunt.citydriveapp.mvp.view.login

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.hazelhunt.citydriveapp.R
import com.hazelhunt.citydriveapp.extensions.inflate
import com.hazelhunt.citydriveapp.mvp.presenter.login.ILoginView
import com.hazelhunt.citydriveapp.mvp.presenter.login.LoginPresenter
import com.hazelhunt.citydriveapp.mvp.view.main.MainActivity

/**
 * Created by ninise on 7/24/16.
 */
class LoginFragment : Fragment(), ILoginView {

    object instance {
        fun newInstance(): LoginFragment = LoginFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = container?.inflate(R.layout.login_fragment)

        var nameEditText = view?.findViewById(R.id.loginUserNameEditText) as EditText
        var passEditText = view?.findViewById(R.id.loginUserPassEditText) as EditText

        var mPresenter = LoginPresenter(this)

        var loginButton = view?.findViewById(R.id.loginButton) as Button
        loginButton.setOnClickListener { mPresenter.login(nameEditText.text.toString(), passEditText.text.toString()) }


        return view
    }

    override fun onLoginSuccess() {
        startActivity(Intent(context, MainActivity::class.java))
    }

    override fun onLoginFail() {

    }
}