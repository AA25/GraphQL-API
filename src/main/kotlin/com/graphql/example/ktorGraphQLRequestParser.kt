package com.graphql.example

import com.expediagroup.graphql.server.execution.GraphQLBatchRequest
import com.expediagroup.graphql.server.execution.GraphQLRequestParser
import com.expediagroup.graphql.server.execution.GraphQLServerRequest
import com.expediagroup.graphql.server.execution.GraphQLSingleRequest
import com.expediagroup.graphql.types.GraphQLRequest
import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import io.ktor.request.*
import java.io.IOException

/*
 * Logic to parse incoming ktor http request into a GraphQLServerRequest
 * Allows for the handling of single and batch requests while validating the shape of the request
 */
class KtorGraphQLRequestParser(
    private val mapper: ObjectMapper
) : GraphQLRequestParser<ApplicationRequest> {

    private val graphQLBatchRequestTypeReference: TypeReference<List<GraphQLRequest>> = object : TypeReference<List<GraphQLRequest>>() {}

    @Suppress("BlockingMethodInNonBlockingContext")
    override suspend fun parseRequest(request: ApplicationRequest): GraphQLServerRequest<*> = try {
        val rawRequest = request.call.receiveText()
        val jsonNode = mapper.readTree(rawRequest)
        if (jsonNode.isArray) {
            GraphQLBatchRequest(mapper.convertValue(jsonNode, graphQLBatchRequestTypeReference))
        } else {
            GraphQLSingleRequest(mapper.treeToValue(jsonNode, GraphQLRequest::class.java))
        }
    } catch (e: IOException) {
        throw IOException("Unable to parse GraphQL payload.")
    }

}
