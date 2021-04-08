package com.graphql.example.schema.models

import com.expediagroup.graphql.generator.annotations.GraphQLDescription
import com.graphql.example.enums.PokemonType
//import com.graphql.example.interfaces.IPokemon

@GraphQLDescription("Contains Pokemon data")
data class Pokemon(
    val name: String,
    val id: Int,
    val type: List<PokemonType>,
    val height: Float,
    val weight: Float,
    val games: List<Int>,
    val relatedPokemonByType: List<PokemonType>,
    val signatureMove: String,
    val imageSource: String,
    val gameId: List<Int>,
    val species: String,
) { // TODO: Applying PokemonInterface seems to break the schema auto generation for some reason?
    companion object {
        fun search(ids: List<Int>): List<Pokemon> {
            return getAllPokemons().filter { ids.contains(it.id) }
        }

        // TODO: Database integration
       fun getAllPokemons(): List<Pokemon> {
            return listOf(
                Pokemon("Pikachu", 25, listOf(PokemonType.ELECTRIC), 0.4f, 6.0f, listOf(0), listOf(PokemonType.ELECTRIC), "Volt Tackle", "http://assets.stickpng.com/images/580b57fcd9996e24bc43c325.png", listOf(1), "Mouse"),
                Pokemon("Bulbasaur", 1, listOf(PokemonType.GRASS, PokemonType.POISON), 0.7f, 6.9f, listOf(0), listOf(PokemonType.GRASS), "Vine Whip", "https://i.pinimg.com/originals/3b/78/47/3b7847675982776e5219e12a680ecd84.png", listOf(1), "Speed"),
                Pokemon("Charmander", 4, listOf(PokemonType.FIRE), 0.6f, 8.5f, listOf(0), listOf(PokemonType.FIRE), "Ember", "https://static.wikia.nocookie.net/pokemon-revolution/images/4/41/004Charmander_OS_anime_2.png/revision/latest/scale-to-width-down/340?cb=20150625082016", listOf(1), "Lizard"),
                Pokemon("Squirtle", 7, listOf(PokemonType.WATER), 0.5f, 9.0f, listOf(0), listOf(PokemonType.WATER), "Rapid Spin", "http://assets.stickpng.com/images/580b57fcd9996e24bc43c32a.png", listOf(1), "Tiny Turtle"),
                Pokemon("Chikorita", 152, listOf(PokemonType.GRASS), 0.9f, 6.4f, listOf(0), listOf(PokemonType.GRASS), "Razor Leaf", "https://static.wikia.nocookie.net/legendsofthemultiuniverse/images/b/bf/152-Chikorita.png/revision/latest?cb=20190224185631", listOf(1), "Leaf"),
                Pokemon("Cyndaquil", 155, listOf(PokemonType.FIRE), 0.5f, 7.9f, listOf(0), listOf(PokemonType.FIRE), "Flame Wheel", "https://pokestop.io/img/pokemon/cyndaquil-256x256.png", listOf(1), "Fire Mouse"),
                Pokemon("Totodile", 158, listOf(PokemonType.WATER), 0.6f, 9.5f, listOf(0), listOf(PokemonType.WATER), "Water Gun", "https://i.pinimg.com/originals/f0/89/7f/f0897f57e05ed84f2480cf9483ff009e.png", listOf(1), "Big Jaw"),
                Pokemon("Treecko", 252, listOf(PokemonType.GRASS), 0.5f, 5.0f, listOf(0), listOf(PokemonType.GRASS), "Leafage", "https://cdn.bulbagarden.net/upload/2/2c/252Treecko.png", listOf(1), "Wood Gecko"),
                Pokemon("Torchic", 255, listOf(PokemonType.FIRE), 0.4f, 2.5f, listOf(0), listOf(PokemonType.FIRE), "Flame Charge", "https://static.wikia.nocookie.net/ultimate-pokemon-fanon/images/0/0e/Torchic_In_Alpha_and_Omega_.png/revision/latest?cb=20140624170103", listOf(1), "Chick Pokémon"),
                Pokemon("Mudkip", 258, listOf(PokemonType.WATER), 0.4f, 7.6f, listOf(0), listOf(PokemonType.WATER), "Water Pulse", "https://cdn.bulbagarden.net/upload/6/60/258Mudkip.png", listOf(1), "Mud Fish"),
                Pokemon("Turtwig", 387, listOf(PokemonType.GRASS), 0.4f, 10.2f, listOf(0), listOf(PokemonType.GRASS), "Absorb", "https://cdn.bulbagarden.net/upload/thumb/5/5c/387Turtwig.png/1200px-387Turtwig.png", listOf(1), "Tiny Leaf"),
                Pokemon("Chimchar", 390, listOf(PokemonType.FIRE), 0.5f, 6.2f, listOf(0), listOf(PokemonType.FIRE), "Flame Wheel", "https://static.wikia.nocookie.net/nintendo/images/9/9f/Chimchar.png/revision/latest?cb=20160916201643&path-prefix=en", listOf(1), "Chimp"),
                Pokemon("Piplup", 393, listOf(PokemonType.WATER), 0.4f, 5.2f, listOf(0), listOf(PokemonType.WATER), "Bubble", "https://i.pinimg.com/originals/b5/99/c9/b599c94a6d790b287decdca3cfeb6382.png", listOf(1), "Penguin"),
            )
       }
    }

    // "Any public functions defined on a query, mutation, or subscription Kotlin class will be translated into
    // GraphQL fields on the object type."

    /*
     *  Return information about the Game associated to a Pokemon
     */
    @Suppress("unused")
    fun games(): List<Game> {
        return Game.getAllGames().filter { gameId.contains(it.id) }
    }
}
