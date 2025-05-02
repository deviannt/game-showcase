package com.example.hw7.data.repository

import com.example.hw7.domain.model.Game
import com.example.hw7.domain.repository.GameRepository
import kotlinx.coroutines.delay

class GameRepositoryImpl : GameRepository {

    override suspend fun getGames(): List<Game> {
        delay(1000)
        return listOf(
            Game(
                id = 1,
                name = "The Witcher 3",
                genre = "RPG",
                platform = "PC/Console",
                imageUrl = "https://upload.wikimedia.org/wikipedia/en/0/0c/Witcher_3_cover_art.jpg"
            ),
            Game(
                id = 2,
                name = "God of War",
                genre = "Action",
                platform = "PlayStation",
                imageUrl = "https://upload.wikimedia.org/wikipedia/en/a/a7/God_of_War_4_cover.jpg"
            ),
            Game(
                id = 3,
                name = "Red Dead Redemption 2",
                genre = "Action-Adventure",
                platform = "PC/Console",
                imageUrl = "https://upload.wikimedia.org/wikipedia/en/4/44/Red_Dead_Redemption_II.jpg"
            ),
            Game(
                id = 4,
                name = "Cyberpunk 2077",
                genre = "RPG",
                platform = "PC/Console",
                imageUrl = "https://upload.wikimedia.org/wikipedia/en/9/9f/Cyberpunk_2077_box_art.jpg"
            )
        )
    }
}
