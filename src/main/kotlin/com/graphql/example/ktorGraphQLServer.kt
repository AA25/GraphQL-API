package com.graphql.example

import com.expediagroup.graphql.server.execution.GraphQLRequestHandler
import com.expediagroup.graphql.server.execution.GraphQLServer
import com.fasterxml.jackson.databind.ObjectMapper
import io.ktor.request.*

/**
 * Helper method for how Ktor creates the common [GraphQLServer] object that can handle requests.
 *
 * @param requestParser Parse the GraphQL request info from the HTTP request
 * @param contextFactory Create a GraphQLContext object from the HTTP request to be used during execution
 * @param requestHandler Send the request and the context to the GraphQL schema to execute and get a response
 */
class KtorGraphQLServer (
    requestParser: KtorGraphQLRequestParser,
    contextFactory: KtorGraphQLContextFactory,
    requestHandler: GraphQLRequestHandler
): GraphQLServer<ApplicationRequest>(requestParser, contextFactory, requestHandler)

fun getGraphQLServer(mapper: ObjectMapper): KtorGraphQLServer {
    val requestParser = KtorGraphQLRequestParser(mapper)
    val contextFactory = KtorGraphQLContextFactory()
    val requestHandler = GraphQLRequestHandler(graphQL, null)

    return KtorGraphQLServer(requestParser, contextFactory, requestHandler)
}
