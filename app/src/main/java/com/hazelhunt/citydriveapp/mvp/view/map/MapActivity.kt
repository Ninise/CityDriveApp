package com.hazelhunt.citydriveapp.mvp.view.map

import android.os.Bundle
import android.util.Log
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.hazelhunt.citydriveapp.R
import com.hazelhunt.citydriveapp.mvp.presenter.map.IMapView
import com.hazelhunt.citydriveapp.mvp.presenter.map.MapPresenter
import com.hazelhunt.citydriveapp.mvp.view.BaseActivity

/**
 * Created by ninise on 9/4/16.
 */
class MapActivity : BaseActivity(), OnMapReadyCallback, IMapView {

    var presenter : MapPresenter = MapPresenter(this)

    var googleMap : GoogleMap? = null
    var mapReady : Boolean? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)

        var mapFragment : SupportMapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap?) {
        mapReady = true
        googleMap = map

        presenter.startLocationListener(this)

        MapsInitializer.initialize(this)
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
        presenter.createMarker(latLng, string(R.string.are_you_here))

        var cameraPosition : CameraPosition = CameraPosition(latLng, 15f, 17f, 65f)
        googleMap!!.moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition))
        presenter.getTrack(latLng, LatLng(47.8461348, 35.133563))
    }
}