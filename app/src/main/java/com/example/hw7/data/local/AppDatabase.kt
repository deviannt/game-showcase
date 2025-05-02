package com.example.hw7.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [GameEntity::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun gameDao(): GameDao
}
