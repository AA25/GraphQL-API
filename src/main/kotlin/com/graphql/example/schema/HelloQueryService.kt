package com.graphql.example.schema

import com.expediagroup.graphql.types.operations.Query

class HelloQueryService: Query {
    fun hello() = "World!"
}
