package service

import datasource.InputZoneDataSource

class NumberZoneService(inputZoneDataSource: InputZoneDataSource) {

    private val zones = inputZoneDataSource.getAllZone()

    fun calculateNumberOfPOIsInZone(minLat: Double, minLon: Double): Int {
        return zones.filter {
            it.lat > minLat && it.lon > minLon
        }.size
    }
}