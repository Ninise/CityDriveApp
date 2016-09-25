package com.hazelhunt.citydriveapp.network.maps

import com.google.android.gms.maps.model.LatLng
import com.hazelhunt.citydriveapp.models.google.DirectionResults

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by ninise on 9/11/16.
 */
object GetDirection {

    fun getCommits(origin: LatLng, destination: LatLng): Observable<DirectionResults> {

        val retrofit = Retrofit.Builder()
                .baseUrl(DirectionsApiResources.ENDPOINT)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service = retrofit.create(DirectionsApiResources::class.java)

        return service.getResources(
                origin.latitude.toString() +  ", " + origin.longitude,
                destination.latitude.toString() + ", " + destination.longitude)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
    }
}
