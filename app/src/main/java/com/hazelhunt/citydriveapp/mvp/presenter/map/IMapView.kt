package com.hazelhunt.citydriveapp.mvp.presenter.map

import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions

/**
 * Created by ninise on 9/11/16.
 */
interface IMapView {

    fun setMarker(markerOptions: MarkerOptions)
    fun drawTrack(polylineOptions: PolylineOptions)
    fun setDeviceLocation(latLng: LatLng)
}