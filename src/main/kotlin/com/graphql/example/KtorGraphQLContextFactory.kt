package com.graphql.example

import com.expediagroup.graphql.server.execution.GraphQLContextFactory
import io.ktor.request.*

/**
 *  This factory will create a GraphQLContext for every http request containing properties of Context class
 */
class KtorGraphQLContextFactory: GraphQLContextFactory<Context, ApplicationRequest> {
    override suspend fun generateContext(request: ApplicationRequest): Context? {
        val customHeader: String? = request.headers["customer-header"]

        return Context(customHeader)
    }

}
