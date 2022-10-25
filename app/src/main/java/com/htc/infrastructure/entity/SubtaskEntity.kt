package com.htc.infrastructure.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey

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
    @PrimaryKey val id: Int,
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
)