package com.sharks.ouioui.data.remote

import com.sharks.ouioui.data.model.Destination
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DestinationApiService {
    @GET("destinations/popular")
    suspend fun getPopularDestinations(): Response<List<Destination>>

    @GET("destinations/search")
    suspend fun searchDestinations(
        @Query("query") query: String
    ): Response<List<Destination>>
}