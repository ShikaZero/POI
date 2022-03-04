package service

import datasource.InputZoneDataSource
import model.Zone
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class DensityZoneServiceTest {

    private val inputZoneDataSource = InputZoneDataSource()
    private val densityZoneService = DensityZoneService(inputZoneDataSource)

    @Test
    fun `should return 2 expected densest zone`() {

        //given
        val numberOfZone = 2
        val expectedResult =  listOf(
            Zone(
            -2.5,
            -2.0,
            38.0,
            38.5
            ),
            Zone(
            6.5,
            7.0,
            -7.0,
            -6.5
            )
        )

        //when
        val numberZoneResult = densityZoneService.findDensestZone(numberOfZone)

        //then
        assertEquals(expectedResult, numberZoneResult)
    }

}