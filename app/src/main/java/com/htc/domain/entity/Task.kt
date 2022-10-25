package com.htc.domain.entity

/**
 * Задача.
 */
data class Task(
    /**
     * Идентификатор задачи.
     */
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
    val subtasks: List<Subtask>,
)
