package com.graphql.example.schema

import com.graphql.example.schema.models.Pokemon
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.types.operations.Query

/*
 * Return list of Pokemon based on PokemonSearchParameter options
 */
class PokemonQueryService: Query {
    @GraphQLDescription("Return list of Pokemon based on PokemonSearchParameter options")
    @Suppress("unused")
    fun pokemon(params: PokemonSearchParameters) = Pokemon.search(params.ids)
}

data class PokemonSearchParameters(val ids: List<Int>)
