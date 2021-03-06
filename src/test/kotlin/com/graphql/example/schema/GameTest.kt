package com.graphql.example.schema

import com.graphql.example.enums.PokemonSeries
import com.graphql.example.schema.models.Game
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockkObject

class GameTest : DescribeSpec({
    val gameMock = Game
    mockkObject(gameMock)

    afterTest {
        clearMocks(gameMock)
    }

    describe("Testing Game class companion object methods not getters/setters"){
        // Currently game data is created and returned statically, in the future this will be coming from a database.
        // To avoid updating tests when that happens, we will instead mock the returned data
        val rbgTestData = Game(90, PokemonSeries.RBG.seriesName, PokemonSeries.RBG.region, PokemonSeries.RBG.year)
        val yrbTestData = Game(91, PokemonSeries.YRB.seriesName, PokemonSeries.YRB.region, PokemonSeries.YRB.year)
        val gsTestData = Game(92, PokemonSeries.GS.seriesName, PokemonSeries.GS.region, PokemonSeries.GS.year)
        val crystalTestData = Game(93, PokemonSeries.CRYSTAL.seriesName, PokemonSeries.CRYSTAL.region, PokemonSeries.CRYSTAL.year)

        every {
            gameMock.getAllGames()
        } returns listOf(
            rbgTestData,
            yrbTestData,
            gsTestData,
            crystalTestData
        )

        describe("search method"){

            it("returns expected games for valid game ids"){
                val expectedResult = listOf(rbgTestData,yrbTestData)
                val actualResult: List<Game> = gameMock.search(listOf(rbgTestData.id,yrbTestData.id))

                actualResult.shouldBe(expectedResult)
            }

            it("returns empty list for invalid ids"){
                val expectedResult = emptyList<String>()
                val invalidIds = listOf(999,888)
                val actualResult: List<Game> = gameMock.search(invalidIds)

                actualResult.shouldBe(expectedResult)
            }
        }
    }
})
