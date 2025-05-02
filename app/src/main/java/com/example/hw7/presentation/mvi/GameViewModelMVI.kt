package com.example.hw7.presentation.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw7.data.repository.GameRepositoryImpl
import com.example.hw7.domain.repository.GameRepository
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class GameViewModelMVI : ViewModel() {

    private val repository: GameRepository = GameRepositoryImpl()

    private val _intent = Channel<GameIntent>(Channel.UNLIMITED)
    val intent = _intent

    private val _state = MutableStateFlow<GameState>(GameState.Idle)
    val state: StateFlow<GameState> get() = _state

    init {
        handleIntents()
    }

    private fun handleIntents() {
        viewModelScope.launch {
            intent.consumeAsFlow().collect {
                when (it) {
                    is GameIntent.LoadGames -> loadGames()
                }
            }
        }
    }

    private fun loadGames() {
        viewModelScope.launch {
            _state.value = GameState.Loading
            try {
                val games = repository.getGames()
                _state.value = GameState.Success(games)
            } catch (e: Exception) {
                _state.value = GameState.Error("Ошибка: ${e.message}")
            }
        }
    }
}
