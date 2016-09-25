package com.hazelhunt.citydriveapp.models.google

/**
 * Created by Nikita on 6/28/2016.
 */
class Location {
    val lat: Double = 0.toDouble()
    val lng: Double = 0.toDouble()

    override fun toString(): String {
        return "Location{" +
                "lat=" + lat +
                ", lng=" + lng +
                '}'
    }
}
