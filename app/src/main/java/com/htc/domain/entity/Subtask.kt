package com.htc.domain.entity

/**
 * Подзадачи.
 */
data class Subtask(
    /**
     * Идентификатор подзадачи.
     */
    val id: Int,
    /**
     * Описание подзадачи.
     */
    val description: String,
    /**
     * Завершённость подзадачи.
     */
    val status: Boolean,
)