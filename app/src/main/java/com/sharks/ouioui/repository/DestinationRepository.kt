package com.sharks.ouioui.repository

import com.sharks.ouioui.data.model.PlaceDetails
import com.sharks.ouioui.data.model.PlaceShort
import com.sharks.ouioui.data.remote.DestinationApiService
import javax.inject.Inject

class DestinationRepository @Inject constructor(
    private val apiService: DestinationApiService,
    private val apiKey: String) {

    suspend fun getNearbyPlaces(lat: Double, lon: Double, radius: Int = 1000): List<PlaceShort>? {
        val response = apiService.getNearbyPlaces(radius, lon, lat, "json", apiKey)
        return if (response.isSuccessful) { response.body() } else { null }
    }

    suspend fun getPlaceDetails(xid: String): PlaceDetails? {
        val response = apiService.getPlaceDetails(xid, apiKey)
        return if (response.isSuccessful) { response.body()?.firstOrNull() } else { null }
    }
}