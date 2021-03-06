package com.graphql.example.schema

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.graphql.example.schema.models.Game

/*
 * Return list of Pokemon based on PokemonSearchParameter options
 */
class GameQueryService {
    @GraphQLDescription("Return list of Pokemon Games based on PokemonGameSearchParameter options")
    @Suppress("unused")
    fun game(params: PokemonGameSearchParameter) = Game.search(params.ids)
}

data class PokemonGameSearchParameter(val ids: List<Int>)
