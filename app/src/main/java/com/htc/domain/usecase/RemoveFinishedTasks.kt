package com.htc.domain.usecase

import com.htc.domain.repository.TaskRepository

/**
 * Сценарий удаления всех завершённых задач.
 */
class RemoveFinishedTasks(
    private val taskRepository: TaskRepository,
) {
    /**
     * Удаляет все завершённые задачи.
     */
    operator fun invoke() = taskRepository.removeFinishedTasks()
}