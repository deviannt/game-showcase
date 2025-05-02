package com.example.hw7.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hw7.databinding.ItemGameBinding
import com.example.hw7.domain.model.Game
import com.example.hw7.utils.loadImage

class GameAdapter(private val games: List<Game>) :
    RecyclerView.Adapter<GameAdapter.GameViewHolder>() {

    inner class GameViewHolder(val binding: ItemGameBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val binding = ItemGameBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return GameViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games[position]
        with(holder.binding) {
            textName.text = game.name
            textGenre.text = game.genre
            textPlatform.text = game.platform
            imageView.loadImage(game.imageUrl)
        }
    }

    override fun getItemCount(): Int = games.size
}
