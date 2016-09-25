package com.hazelhunt.citydriveapp.network.maps

import com.hazelhunt.citydriveapp.models.google.DirectionResults

import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

/**
 * Created by ninise on 9/11/16.
 */
interface DirectionsApiResources {

    @GET("/maps/api/directions/json")
    fun getResources(@Query("origin") origin: String, @Query("destination") destination: String): Observable<DirectionResults>

    companion object {

        val ENDPOINT = "https://maps.googleapis.com/"
    }
}
