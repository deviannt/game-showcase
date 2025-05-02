package com.example.hw7.presentation.mvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hw7.domain.model.Game
import com.example.hw7.domain.repository.GameRepository
import com.example.hw7.data.repository.GameRepositoryImpl
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {

    private val repository: GameRepository = GameRepositoryImpl()

    private val _games = MutableStateFlow<List<Game>>(emptyList())
    val games: StateFlow<List<Game>> get() = _games

    init {
        loadGames()
    }

    private fun loadGames() {
        viewModelScope.launch {
            val result = repository.getGames()
            _games.value = result
        }
    }
}
