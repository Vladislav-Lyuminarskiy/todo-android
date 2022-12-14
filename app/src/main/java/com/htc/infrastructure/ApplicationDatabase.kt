package com.htc.infrastructure

import androidx.room.Database
import androidx.room.RoomDatabase
import com.htc.infrastructure.dao.SubtaskDao
import com.htc.infrastructure.dao.TaskDao
import com.htc.infrastructure.entity.SubtaskEntity
import com.htc.infrastructure.entity.TaskEntity

@Database(
    entities = [
        TaskEntity::class,
        SubtaskEntity::class,
    ],
    version = 1,
    exportSchema = false,
)
abstract class ApplicationDatabase: RoomDatabase() {
    abstract fun taskDao(): TaskDao
    abstract fun subtaskDao(): SubtaskDao
}