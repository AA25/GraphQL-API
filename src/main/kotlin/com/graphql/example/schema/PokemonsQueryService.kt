package com.graphql.example.schema

import com.graphql.example.schema.models.Pokemon
import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.types.operations.Query

/*
 * Return list based on all Pokemon
 */
class PokemonsQueryService: Query {
    @GraphQLDescription("Return list based on all Pokemon")
    @Suppress("unused")
    fun pokemons() = Pokemon.getAllPokemons()
}
