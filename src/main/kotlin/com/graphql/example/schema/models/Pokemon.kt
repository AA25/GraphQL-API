package com.graphql.example.schema.models

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.graphql.example.enums.PokemonType
//import com.graphql.example.interfaces.IPokemon

@GraphQLDescription("Contains Pokemon data")
data class Pokemon(
    val name: String,
    val id: Int,
    val type: List<PokemonType>,
    val height: Int,
    val weight: Int,
    val games: List<Int>,
    val relatedPokemonByType: List<PokemonType>,
    val signatureMove: String,
    val imageLink: String,
    val gameId: List<Int>,
) { // TODO: Applying PokemonInterface seems to break the schema auto generation for some reason?
    companion object {
        fun search(ids: List<Int>): List<Pokemon> {
            return getAllPokemons().filter { ids.contains(it.id) }
        }

       fun getAllPokemons(): List<Pokemon> {
            return listOf(
                Pokemon("Pikachu", 25, listOf(PokemonType.ELECTRIC), 0, 0, listOf(0), listOf(PokemonType.ELECTRIC), "Volt Tackle", "imageLink", listOf(1)),
                Pokemon("Bulbasaur", 1, listOf(PokemonType.GRASS, PokemonType.POISON), 0, 0, listOf(0), listOf(PokemonType.GRASS), "Vine Whip", "imageLink", listOf(1)),
                Pokemon("Charmander", 4, listOf(PokemonType.FIRE), 0, 0, listOf(0), listOf(PokemonType.FIRE), "Ember", "imageLink", listOf(1)),
                Pokemon("Squirtle", 7, listOf(PokemonType.WATER), 0, 0, listOf(0), listOf(PokemonType.WATER), "Water Gun", "imageLink", listOf(1))
            )
       }
    }

    // "Any public functions defined on a query, mutation, or subscription Kotlin class will be translated into
    // GraphQL fields on the object type."

    /*
     *  Return information about the Game associated to a Pokemon
     */
    @Suppress("unused")
    fun games(): List<Game> {
        return Game.getAllGames().filter { gameId.contains(it.id) }
    }
}
