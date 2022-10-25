package com.htc.domain.usecase

import com.htc.domain.repository.TaskRepository

/**
 * Сценарий установления завершённости задачи.
 */
class SetTaskStatus(
    private val taskRepository: TaskRepository
) {
    /**
     * Устанавливает завершённость [status] у задачи с идентификатором [id].
     */
    fun execute(id: Int, status: Boolean) = taskRepository.setStatus(id, status)
}