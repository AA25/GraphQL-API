package com.graphql.example.schema

import com.graphql.example.enums.PokemonType
import com.graphql.example.schema.models.Pokemon
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockkObject

class PokemonTest: DescribeSpec({
    val pokemonMock = Pokemon
    mockkObject(pokemonMock)

    afterTest {
        clearMocks(pokemonMock)
    }

    describe("Testing Pokemon class companion object methods not getters/setters"){
        // Currently pokemon data is created and returned statically, in the future this will be coming from a database.
        // To avoid updating tests when that happens, we will instead mock the returned data
        val pikachuTest = Pokemon("Pikachu", 25, listOf(PokemonType.ELECTRIC), 0.0f, 0.0f, listOf(0), listOf(PokemonType.ELECTRIC), "Volt Tackle", "imageSource", listOf(1))
        val bulbasaurTest = Pokemon("Bulbasaur", 1, listOf(PokemonType.GRASS, PokemonType.POISON), 0.0f, 0.0f, listOf(0), listOf(PokemonType.GRASS), "Vine Whip", "imageSource", listOf(1))
        val charmanderTest = Pokemon("Charmander", 4, listOf(PokemonType.FIRE), 0.0f, 0.0f, listOf(0), listOf(PokemonType.FIRE), "Ember", "imageSource", listOf(1))
        val squirtleTest = Pokemon("Squirtle", 7, listOf(PokemonType.WATER), 0.0f, 0.0f, listOf(0), listOf(PokemonType.WATER), "Water Gun", "imageSource", listOf(1))

        every {
            pokemonMock.getAllPokemons()
        } returns listOf(
            pikachuTest,
            bulbasaurTest,
            charmanderTest,
            squirtleTest,
        )

        describe("search method"){

            it("returns expected pokemnos for valid pokemon ids"){
                val expectedResult = listOf(charmanderTest,squirtleTest)
                val actualResult: List<Pokemon> = pokemonMock.search(listOf(charmanderTest.id,squirtleTest.id))

                actualResult.shouldBe(expectedResult)
            }

            it("returns empty list for invalid pokemon ids"){
                val expectedResult = emptyList<String>()
                val invalidIds = listOf(999,888)
                val actualResult: List<Pokemon> = pokemonMock.search(invalidIds)

                actualResult.shouldBe(expectedResult)
            }
        }
    }
})
