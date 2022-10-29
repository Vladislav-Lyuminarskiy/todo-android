package com.htc.infrastructure.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.htc.domain.entity.Task

/**
 * Представление задачи для СУБД.
 */
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
) {
    /**
     * Создаёт представление задачи для СУБД на основе задачи доменного слоя [task].
     */
    constructor(task: Task) : this(
        id = task.id,
        description = task.description,
        status = task.status,
    )
}