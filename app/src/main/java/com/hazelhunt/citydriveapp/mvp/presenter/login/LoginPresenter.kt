package com.hazelhunt.citydriveapp.mvp.presenter.login

/**
 * Created by ninise on 7/25/16.
 */
class LoginPresenter(view : ILoginView) : ILoginPresenter {

    var mView = view

    override fun login(name: String, pass: String) {
        mView.onLoginSuccess()
    }

    override fun forgot() {

    }
}