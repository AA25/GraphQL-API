package com.graphql.example

import com.expediagroup.graphql.generator.execution.GraphQLContext
import java.util.*

/*
 * Example of a custom GraphQLContext which will be created for every request and be used during execution.
 */
data class Context(
    val customHeader: String? = null
) : GraphQLContext {
    val uuid: UUID = UUID.randomUUID()
}
