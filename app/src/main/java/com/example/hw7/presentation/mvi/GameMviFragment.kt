package com.example.hw7.presentation.mvi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.hw7.databinding.FragmentGameBinding
import com.example.hw7.ui.adapter.GameAdapter
import kotlinx.coroutines.launch

class GameMviFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GameViewModelMVI by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        lifecycleScope.launch {
            viewModel.intent.send(GameIntent.LoadGames)
        }

        lifecycleScope.launch {
            viewModel.state.collect { state ->
                when (state) {
                    is GameState.Loading -> {
                        // показать прогресс
                    }
                    is GameState.Success -> {
                        binding.recyclerView.adapter = GameAdapter(state.games)
                    }
                    is GameState.Error -> {
                        // показать ошибку
                    }
                    else -> Unit
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
