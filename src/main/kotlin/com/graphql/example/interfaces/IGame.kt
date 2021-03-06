package com.graphql.example.interfaces

import com.graphql.example.enums.Region

interface IGame {
    val id: Int
    val game: String
    val region: Region
    val releaseYear: String
}
