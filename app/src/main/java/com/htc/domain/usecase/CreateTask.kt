package com.htc.domain.usecase

import com.htc.domain.entity.Task
import com.htc.domain.repository.TaskRepository

/**
 * Сценарий создания задачи.
 */
class CreateTask(
    private val taskRepository: TaskRepository,
) {
    /**
     * Создаёт задачу с описанием [description].
     */
    operator fun invoke(description: String) = taskRepository.createTask(
        Task(
            id = 0,
            description = description,
            status = false,
            subtasks = emptyList()
        )
    )
}