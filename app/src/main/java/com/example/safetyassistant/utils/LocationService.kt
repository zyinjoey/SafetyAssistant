package com.example.safetyassistant.utils

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import android.os.Bundle
import android.os.Looper
import androidx.core.content.ContextCompat
import java.util.Locale

class LocationService(private val context: Context) {

    private var locationManager: LocationManager? = null
    private var locationCallback: ((LocationData?) -> Unit)? = null
    private var locationListener: LocationListener? = null

    fun init() {
        locationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
    }

    fun startLocation(callback: (LocationData?) -> Unit) {
        locationCallback = callback

        if (locationManager == null) {
            init()
        }

        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
            callback(null)
            return
        }

        val lastKnownLocation = getLastKnownLocation()
        if (lastKnownLocation != null) {
            val locationData = LocationData(
                latitude = lastKnownLocation.latitude,
                longitude = lastKnownLocation.longitude,
                address = getAddress(lastKnownLocation.latitude, lastKnownLocation.longitude)
            )
            callback(locationData)
        }

        locationListener = object : LocationListener {
            override fun onLocationChanged(location: Location) {
                val locationData = LocationData(
                    latitude = location.latitude,
                    longitude = location.longitude,
                    address = getAddress(location.latitude, location.longitude)
                )
                locationCallback?.invoke(locationData)
            }

            override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {}
            override fun onProviderEnabled(provider: String) {}
            override fun onProviderDisabled(provider: String) {}
        }

        try {
            if (locationManager?.isProviderEnabled(LocationManager.GPS_PROVIDER) == true) {
                locationManager?.requestSingleUpdate(
                    LocationManager.GPS_PROVIDER,
                    locationListener!!,
                    Looper.getMainLooper()
                )
            }
        } catch (e: SecurityException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        try {
            locationManager?.requestSingleUpdate(
                LocationManager.NETWORK_PROVIDER,
                locationListener!!,
                Looper.getMainLooper()
            )
        } catch (e: SecurityException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun getLastKnownLocation(): Location? {
        if (ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
            != PackageManager.PERMISSION_GRANTED) {
            return null
        }

        try {
            val gpsLocation = locationManager?.getLastKnownLocation(LocationManager.GPS_PROVIDER)
            if (gpsLocation != null) {
                return gpsLocation
            }
        } catch (e: SecurityException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        try {
            val networkLocation = locationManager?.getLastKnownLocation(LocationManager.NETWORK_PROVIDER)
            if (networkLocation != null) {
                return networkLocation
            }
        } catch (e: SecurityException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return null
    }

    private fun getAddress(latitude: Double, longitude: Double): String {
        return try {
            val geocoder = Geocoder(context, Locale.getDefault())
            val addresses = geocoder.getFromLocation(latitude, longitude, 1)
            if (addresses != null && addresses.isNotEmpty()) {
                addresses[0].getAddressLine(0) ?: ""
            } else {
                ""
            }
        } catch (e: Exception) {
            e.printStackTrace()
            ""
        }
    }

    fun stopLocation() {
        locationListener?.let {
            try {
                locationManager?.removeUpdates(it)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
        locationCallback = null
    }

    fun destroy() {
        stopLocation()
        locationManager = null
    }

    companion object {
        fun calculateDistance(
            lat1: Double,
            lon1: Double,
            lat2: Double,
            lon2: Double
        ): Float {
            val results = FloatArray(1)
            Location.distanceBetween(lat1, lon1, lat2, lon2, results)
            return results[0]
        }

        fun formatDistance(distanceMeters: Float): String {
            return when {
                distanceMeters < 1000 -> "${distanceMeters.toInt()}米"
                else -> String.format("%.1f公里", distanceMeters / 1000)
            }
        }
    }
}

data class LocationData(
    val latitude: Double,
    val longitude: Double,
    val address: String
)