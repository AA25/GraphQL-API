package com.graphql.example.schema

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.graphql.example.schema.models.Game

/*
 * Return list of all Pokemon Games
 */
class GamesQueryService {
    @GraphQLDescription("Return list of all Pokemon Games")
    @Suppress("unused")
    fun games() = Game.getAllGames()
}
