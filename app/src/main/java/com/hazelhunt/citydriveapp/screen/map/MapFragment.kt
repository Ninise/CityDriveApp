package com.hazelhunt.citydriveapp.screen.map

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.hazelhunt.citydriveapp.R
import com.hazelhunt.citydriveapp.extensions.inflate
import com.hazelhunt.citydriveapp.mvp.presenter.map.IMapView
import com.hazelhunt.citydriveapp.mvp.presenter.map.MapPresenter

/**
 * Created by ninise on 8/28/16.
 */
class MapFragment : Fragment(), OnMapReadyCallback, IMapView {

    var presenter : MapPresenter = MapPresenter(this)

    var googleMap : GoogleMap? = null
    var mapReady : Boolean? = null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view = container?.inflate(R.layout.map_fragment)

        var mapFragment : SupportMapFragment = activity.supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        return view!!
    }


    override fun onMapReady(map: GoogleMap?) {
        mapReady = true
        googleMap = map

        presenter.startLocationListener(activity)

        MapsInitializer.initialize(activity)
    }

    override fun setMarker(markerOptions: MarkerOptions) {
        if (googleMap != null) {
            googleMap!!.addMarker(markerOptions)
        }
    }

    override fun drawTrack(polylineOptions: PolylineOptions) {
        googleMap!!.addPolyline(polylineOptions)
    }

    override fun setDeviceLocation(latLng: LatLng) {
        presenter.createMarker(latLng, activity.getString(R.string.are_you_here))

        val cameraPosition : CameraPosition = CameraPosition(latLng, 15f, 17f, 65f)
        googleMap!!.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
        presenter.getTrack(latLng, LatLng(47.8461348, 35.133563))
    }
}