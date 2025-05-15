package com.sharks.ouioui.data.remote

import com.sharks.ouioui.data.model.PlaceDetails
import com.sharks.ouioui.data.model.PlaceShort
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DestinationApiService {
    @GET("places/radius")
    suspend fun getNearbyPlaces(
        @Query("radius") radius: Int = 1000,
        @Query("lon") lon: Double,
        @Query("lat") lat: Double,
        @Query("format") format: String = "json",
        @Query("apikey") apiKey: String
    ): Response<List<PlaceShort>>

    @GET("places/xid/{xid}")
    suspend fun getPlaceDetails(
        @Path("xid") xid: String,
        @Query("apikey") apiKey: String
    ): Response<List<PlaceDetails>>
}