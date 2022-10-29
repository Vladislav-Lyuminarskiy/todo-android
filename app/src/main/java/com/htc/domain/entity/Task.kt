package com.htc.domain.entity

import io.reactivex.rxjava3.core.Flowable

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
    val subtasks: Flowable<List<Subtask>>,
)