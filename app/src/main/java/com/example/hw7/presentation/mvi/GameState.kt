package com.example.hw7.presentation.mvi

import com.example.hw7.domain.model.Game

sealed class GameState {
    object Idle : GameState()
    object Loading : GameState()
    data class Success(val games: List<Game>) : GameState()
    data class Error(val message: String) : GameState()
}
