package com.example.hw7.data.repository

import android.content.Context
import androidx.room.Room
import com.example.hw7.data.local.AppDatabase
import com.example.hw7.data.local.GameDao
import com.example.hw7.data.local.GameEntity
import com.example.hw7.data.local.MIGRATION_1_2
import kotlinx.coroutines.flow.Flow

class GameLocalRepository(context: Context) {

    private val db: AppDatabase = Room.databaseBuilder(
        context.applicationContext,
        AppDatabase::class.java,
        "game_database"
    )
        .addMigrations(MIGRATION_1_2)
        .build()

    private val dao: GameDao = db.gameDao()

    fun getAllGames(): Flow<List<GameEntity>> = dao.getAll()

    suspend fun insertGame(game: GameEntity) {
        dao.insert(game)
    }

    suspend fun insertSampleDataIfEmpty() {
        val existing = dao.getAllOnce()
        if (existing.isEmpty()) {
            dao.insertAll(
                listOf(
                    GameEntity(name = "The Witcher 3", genre = "RPG", platform = "PC", releaseYear = 2015),
                    GameEntity(name = "God of War", genre = "Action", platform = "PlayStation", releaseYear = 2018),
                    GameEntity(name = "Red Dead Redemption 2", genre = "Action-Adventure", platform = "PC", releaseYear = 2019),
                    GameEntity(name = "Cyberpunk 2077", genre = "RPG", platform = "PC", releaseYear = 2020)
                )
            )
        }
    }
}
