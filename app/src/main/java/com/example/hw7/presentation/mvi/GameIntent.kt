package com.example.hw7.presentation.mvi

sealed class GameIntent {
    object LoadGames : GameIntent()
}
