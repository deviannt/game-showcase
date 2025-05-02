package com.example.hw7.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface GameDao {
    @Query("SELECT * FROM games")
    fun getAll(): Flow<List<GameEntity>>

    @Query("SELECT * FROM games")
    suspend fun getAllOnce(): List<GameEntity>

    @Insert
    suspend fun insert(game: GameEntity)

    @Insert
    suspend fun insertAll(games: List<GameEntity>)
}
