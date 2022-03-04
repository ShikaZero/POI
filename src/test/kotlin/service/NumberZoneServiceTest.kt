package service

import datasource.InputZoneDataSource
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class NumberZoneServiceTest{
    private val inputZoneDataSource = InputZoneDataSource()
    private val numberZoneService = NumberZoneService(inputZoneDataSource)

    @Test
    fun `should calculate POIs number zone depending on lat and lon`() {

        //given
        val minLat = 6.5
        val minLon = -7.0
        val expectedResult = 2

        //when
        val numberZoneResult = numberZoneService.calculateNumberOfPOIsInZone(minLat, minLon)

        //then
        Assertions.assertEquals(expectedResult, numberZoneResult)
    }
}