package com.sharks.ouioui.data.model

data class PlaceDetails(
    val xid: String,
    val name: String?,
    val image: String?,
    val wikipediaExtracts: WikipediaExtracts?,
    val point: Point,
)

data class WikipediaExtracts(
    val text: String?
)