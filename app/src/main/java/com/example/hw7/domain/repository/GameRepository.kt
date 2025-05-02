package com.example.hw7.domain.repository

import com.example.hw7.domain.model.Game

interface GameRepository {
    suspend fun getGames(): List<Game>
}
