package com.example.hw7.presentation.mvvm

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
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    private val viewModel: GameViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())

        lifecycleScope.launch {
            viewModel.games.collectLatest { games ->
                binding.recyclerView.adapter = GameAdapter(games)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
