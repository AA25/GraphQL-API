package com.graphql.example.interfaces

import com.graphql.example.enums.PokemonType

// Expected pokemon properties
interface IPokemon {
    val name: String
    val id: Int
    val type: List<PokemonType>
    val height: Int
    val weight: Int
    val games: List<Int>
    val relatedPokemonByType: List<PokemonType>
    val signatureMove: String
    val imageSource: String
    val gameId: List<Int>
}
