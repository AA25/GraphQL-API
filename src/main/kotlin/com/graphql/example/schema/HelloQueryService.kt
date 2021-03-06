package com.graphql.example.schema

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.expediagroup.graphql.types.operations.Query

class HelloQueryService: Query {
    @GraphQLDescription("Basic hello world example")
    @Deprecated("Not needed anymore", ReplaceWith("\"Pokemon\""))
    fun hello() = "World!"
}
