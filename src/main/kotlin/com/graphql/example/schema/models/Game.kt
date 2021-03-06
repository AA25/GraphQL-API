package com.graphql.example.schema.models

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.graphql.example.enums.PokemonSeries
import com.graphql.example.enums.Region

@GraphQLDescription("Contains data on Pokemon games within the series")
data class Game(
    val id: Int,
    val name: String,
    val region: Region,
    val year: String
) {
    companion object {
        fun search(ids: List<Int>): List<Game> {
            return getAllGames().filter { ids.contains(it.id) }
        }

        fun getAllGames(): List<Game> {
            return pokemonDataStore()
        }

        private fun pokemonDataStore(): List<Game> {
            return listOf(
                Game(1, PokemonSeries.RBG.seriesName, PokemonSeries.RBG.region, PokemonSeries.RBG.year),
                Game(2, PokemonSeries.YRB.seriesName, PokemonSeries.YRB.region, PokemonSeries.YRB.year),
                Game(3, PokemonSeries.GS.seriesName, PokemonSeries.GS.region, PokemonSeries.GS.year),
                Game(4, PokemonSeries.CRYSTAL.seriesName, PokemonSeries.CRYSTAL.region, PokemonSeries.CRYSTAL.year),
            )
        }
    }

    // "Any public functions defined on a query, mutation, or subscription Kotlin class will be translated into
    // GraphQL fields on the object type."

    /*
     *  Return information about the Pokemons associated to this Game
     */
    @Suppress("unused")
    fun pokemons(): List<Pokemon> {
        return Pokemon.getAllPokemons().filter { it.gameId.contains(id) }
    }
}
