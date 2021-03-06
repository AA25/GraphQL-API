package com.graphql.example

import com.expediagroup.graphql.generator.SchemaGeneratorConfig
import com.expediagroup.graphql.generator.TopLevelObject
import com.expediagroup.graphql.generator.toSchema
import com.graphql.example.schema.*
import graphql.GraphQL

private val config = SchemaGeneratorConfig(supportedPackages = listOf("com.graphql.example"))
private val queries = listOf(
//    TopLevelObject(HelloQueryService()),
    TopLevelObject(HelloQueryService()),
    TopLevelObject(PokemonQueryService()),
    TopLevelObject(PokemonsQueryService()),
    TopLevelObject(GameQueryService()),
    TopLevelObject(GamesQueryService()),
)

// Any public functions defined on query Kotlin class will be translated into GQL fields on the obj type.
// toSchema will then recursively applu Kotlin reflection on the specified classes
private val graphQLSchema = toSchema(config, queries)

// Our root access to query GQL
val graphQL: GraphQL = GraphQL.newGraphQL(graphQLSchema).build()
