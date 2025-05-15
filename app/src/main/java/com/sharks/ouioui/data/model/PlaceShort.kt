package com.sharks.ouioui.data.model

data class PlaceShort(
    val xid: String,
    val name: String?,
    val kinds: String?,
    val point: Point
)

data class Point(
    val lat: Double,
    val lon: Double
)