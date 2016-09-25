package com.hazelhunt.citydriveapp.mvp.presenter.map

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.support.v4.app.ActivityCompat
import android.util.Log
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import com.hazelhunt.citydriveapp.models.google.DirectionResults
import com.hazelhunt.citydriveapp.models.google.Location
import com.hazelhunt.citydriveapp.models.google.Steps
import com.hazelhunt.citydriveapp.network.maps.GetDirection
import com.hazelhunt.citydriveapp.utils.MapDecoder
import fr.quentinklein.slt.LocationTracker
import fr.quentinklein.slt.TrackerSettings
import rx.Observable
import rx.functions.Func1
import java.util.*

/**
* Created by ninise on 9/11/16.
*/
class MapPresenter(private val mView: IMapView) : IMapPresenter {

    override fun startLocationListener(context: Context) {
        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

            return
        }
        val tracker = object : LocationTracker(context, TrackerSettings().setUseGPS(false).setUseNetwork(true).setUsePassive(false)) {
            override fun onLocationFound(location: android.location.Location) {
                mView.setDeviceLocation(LatLng(location.latitude, location.longitude))

                stopListening()
            }

            override fun onTimeout() {
            }
        }
        tracker.startListening()
    }

    override fun getTrack(from: LatLng, to: LatLng) {
        GetDirection.getCommits(from, to).flatMap<DirectionResults>(Func1<DirectionResults, Observable<out DirectionResults>> { Observable.just(it) })?.subscribe { pojos ->

            val routes = ArrayList<LatLng>()

            if (pojos.routes!!.size > 0) {

                val routeA = pojos.routes[0]

                if (routeA.legs!!.size > 0) {

                    val steps = routeA.legs[0].steps

                    var step: Steps
                    var location: com.hazelhunt.citydriveapp.models.google.Location
                    var polyline: String

                    for (i in steps!!.indices) {
                        step = steps[i]
                        location = step.start_location as Location

                        routes.add(LatLng(location.lat, location.lng))

                        polyline = step.polyline?.points!!


                        val decoder : MapDecoder = MapDecoder()
                        routes.addAll(decoder.decodePoly(polyline))

                        location = step.end_location!!

                        routes.add(LatLng(location.lat, location.lng))
                    }
                }
            }
            if (routes.size > 0) {
                val rectLine = PolylineOptions().width(10f).color(Color.RED)

                for (i in routes.indices) {
                    rectLine.add(routes[i])
                }

                mView.drawTrack(rectLine)
            }
        }
    }

    override fun createMarker(lanLng: LatLng, title: String) {
        val markerOptions = MarkerOptions()
        markerOptions.position(lanLng)
        markerOptions.title(title)
        mView.setMarker(markerOptions)
    }
}
