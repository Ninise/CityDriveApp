package com.hazelhunt.citydriveapp.mvp.presenter.login

/**
 * Created by ninise on 7/25/16.
 */
interface ILoginPresenter {

    fun login(name : String, pass : String)
    fun forgot()

}