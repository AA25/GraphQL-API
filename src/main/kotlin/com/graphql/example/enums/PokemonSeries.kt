package com.graphql.example.enums

enum class PokemonSeries(val gameName: String, val region: Region, val year: String) {
    RBG("Pokemon Red, Blue & Green", Region.KANTO, "1996")
}
