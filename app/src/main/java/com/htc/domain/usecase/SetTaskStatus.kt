package com.htc.domain.usecase

import com.htc.domain.repository.TaskRepository

class SetTaskStatus(
    private val taskRepository: TaskRepository
) {
    fun execute(id: Int, status: Boolean) = taskRepository.setStatus(id, status)
}