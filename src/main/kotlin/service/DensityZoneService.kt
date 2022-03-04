package service

import datasource.InputZoneDataSource
import model.InterestPoint
import model.WORLD
import model.Zone
import objectbuilder.NumberBuilder.roundDownToMultipleOf
import objectbuilder.ZoneBuilder.buildPairFromLatitudeAndLongitude
import java.lang.Math.floor
import kotlin.math.ceil

class DensityZoneService(inputZoneDataSource: InputZoneDataSource) {

    private val inputPOIs = inputZoneDataSource.getAllZone()

    fun findDensestZone(numberOfZone: Int): List<Zone>{
        return calculateTheMinimulLongitude(numberOfZone)
    }

    private fun calculateTheMinimulLongitude(numberOfZone: Int) : List<Zone> = inputPOIs.mapIndexed { index, interestPoint ->
            val tempMinValues = mutableListOf<Pair<Double,Double>>()
            tempMinValues.add(Pair(interestPoint.lat.roundDownToMultipleOf(
                -WORLD.INCREMENT_VALUE), interestPoint.lon.roundDownToMultipleOf(-WORLD.INCREMENT_VALUE))
            )
            buildPairFromLatitudeAndLongitude(interestPoint, tempMinValues, index)
        }.sortedBy { it.second }.reversed().map { it.first }.distinct().take(numberOfZone)

}