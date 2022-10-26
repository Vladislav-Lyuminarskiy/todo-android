package com.htc.infrastructure.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
import com.htc.domain.entity.Subtask

@Entity(tableName = "tasks")
data class TaskEntity(
    /**
     * Идентификатор задачи.
     */
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    /**
     * Описание задачи.
     */
    val description: String,
    /**
     * Завершённость задачи.
     */
    val status: Boolean,
    /**
     * Подзадачи.
     */
    @Relation(
        parentColumn = "id",
        entityColumn = "taskId"
    )
    val subtasks: List<Subtask>,
)