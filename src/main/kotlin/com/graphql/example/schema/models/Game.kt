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
            return listOf(
                Game(1, PokemonSeries.RBG.gameName, PokemonSeries.RBG.region, PokemonSeries.RBG.year)
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
