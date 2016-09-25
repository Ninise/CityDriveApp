package com.hazelhunt.citydriveapp.mvp.presenter.map

import android.content.Context
import com.google.android.gms.maps.model.LatLng

/**
 * Created by ninise on 9/11/16.
 */
interface IMapPresenter {

    fun startLocationListener(context : Context)
    fun getTrack(from : LatLng, to : LatLng)
    fun createMarker(lanLng: LatLng, title : String)

}
