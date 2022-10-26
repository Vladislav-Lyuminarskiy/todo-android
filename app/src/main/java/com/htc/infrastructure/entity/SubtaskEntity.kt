package com.htc.infrastructure.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.htc.domain.entity.Subtask

/**
 * Представление подзадачи для СУБД.
 */
@Entity(
    tableName = "subtasks",
    foreignKeys = [ForeignKey(
        entity = TaskEntity::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("taskId"),
        onDelete = CASCADE
    )]
)
data class SubtaskEntity(
    /**
     * Идентификатор подзадачи.
     */
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    /**
     * Идентификатор родительской задачи.
     */
    val taskId: Int,
    /**
     * Описание подзадачи.
     */
    val description: String,
    /**
     * Завершённость подзадачи.
     */
    val status: Boolean,
) {
    /**
     * Создаёт представление подзадачи для СУБД на основе подзадачи доменного слоя [subtask]
     * для родительской задачи с идентификатором [taskId].
     */
    constructor(taskId: Int, subtask: Subtask) : this(
        id = subtask.id,
        taskId = taskId,
        description = subtask.description,
        status = subtask.status
    )

    /**
     * Преобразует представление подзадачи для СУБД в подзадачу доменного слоя.
     */
    fun toDomain() = Subtask(
        id = id,
        description = description,
        status = status,
    )
}