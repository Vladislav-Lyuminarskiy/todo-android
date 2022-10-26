package com.htc.domain.usecase

import com.htc.domain.entity.Task
import com.htc.domain.repository.TaskRepository

/**
 * Сценарий получения списка всех задач.
 */
class GetTasks(
    private val taskRepository: TaskRepository,
) {
    /**
     * Возвращает список всех задач.
     */
    operator fun invoke(): List<Task> = taskRepository.getTasks()
}