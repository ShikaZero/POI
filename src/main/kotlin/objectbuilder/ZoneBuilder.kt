package objectbuilder

import model.InterestPoint
import model.WORLD
import model.Zone
import objectbuilder.NumberBuilder.roundDownToMultipleOf

object ZoneBuilder {
    fun buildPairFromLatitudeAndLongitude(
        interestPoint: InterestPoint,
        tempMinValues: MutableList<Pair<Double, Double>>,
        index: Int
    ) = Pair(
        Zone(
            interestPoint.lat.roundDownToMultipleOf(-WORLD.INCREMENT_VALUE),
            interestPoint.lat.roundDownToMultipleOf(-WORLD.INCREMENT_VALUE) + WORLD.INCREMENT_VALUE,
            interestPoint.lon.roundDownToMultipleOf(-WORLD.INCREMENT_VALUE),
            interestPoint.lon.roundDownToMultipleOf(-WORLD.INCREMENT_VALUE) + WORLD.INCREMENT_VALUE
        ),
        tempMinValues.any { poi ->
            index != 0 && poi.first.roundDownToMultipleOf(-WORLD.INCREMENT_VALUE) == interestPoint.lat.roundDownToMultipleOf(
                -WORLD.INCREMENT_VALUE
            )
                    && poi.second.roundDownToMultipleOf(-WORLD.INCREMENT_VALUE) == interestPoint.lon.roundDownToMultipleOf(
                -WORLD.INCREMENT_VALUE
            )
        }.let {
            tempMinValues.filter { temp ->
                temp.first == interestPoint.lat.roundDownToMultipleOf(-WORLD.INCREMENT_VALUE)
            }.size
        }
    )

}