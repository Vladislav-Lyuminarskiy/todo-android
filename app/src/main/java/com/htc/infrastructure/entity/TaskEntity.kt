package com.htc.infrastructure.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.Relation
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
    /**
     * Подзадачи.
     */
    @Relation(
        parentColumn = "id",
        entityColumn = "taskId"
    )
    // TODO: Исправить "Entities cannot have relations".
    val subtasks: List<SubtaskEntity>,
) : EntityBase<Task> {
    /**
     * Создаёт представление задачи для СУБД на основе задачи доменного слоя [task].
     */
    constructor(task: Task) : this(
        id = task.id,
        description = task.description,
        status = task.status,
        subtasks = task.subtasks.map { SubtaskEntity(task.id, it) })

    /**
     * Преобразует представление задачи для СУБД в задачу доменного слоя.
     */
    override fun toDomain() = Task(
        id = id,
        description = description,
        status = status,
        subtasks = subtasks.map { it.toDomain() }
    )
}