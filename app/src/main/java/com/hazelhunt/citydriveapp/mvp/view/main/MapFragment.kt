package com.hazelhunt.citydriveapp.mvp.view.main

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.hazelhunt.citydriveapp.R
import com.hazelhunt.citydriveapp.extensions.inflate

/**
 * Created by ninise on 8/28/16.
 */
class MapFragment : Fragment(), OnMapReadyCallback {

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        var view = container?.inflate(R.layout.map_fragment)

        var mapFragment : SupportMapFragment = activity.supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync { this }

        return view!!
    }

    override fun onMapReady(p0: GoogleMap?) {
        var zp : LatLng = LatLng(47.8556033, 35.0352706)
        p0!!.addMarker(MarkerOptions().position(zp).title("Zaporozhye"))
        p0.moveCamera(CameraUpdateFactory.newLatLng(zp))
    }
}