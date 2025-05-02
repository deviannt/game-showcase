package com.example.hw7.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "games")
data class GameEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val genre: String,
    val platform: String,
    val releaseYear: Int? = null
)
