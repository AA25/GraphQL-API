package com.graphql.example.enums

enum class PokemonSeries(val seriesName: String, val region: Region, val year: String) {
    RBG("Pokemon Red, Blue and Green", Region.KANTO, "1996"),
    YRB("Pokemon Yellow, Red and Blue", Region.KANTO,"1998"),
    GS("Pokemon Gold and Silver", Region.KANTO,"1998"),
    CRYSTAL("Pokemon Crystal", Region.KANTO, "2000")
}
