package com.htc.domain.usecase

import com.htc.domain.repository.TaskRepository

class RemoveFinishedTasks(
    private val taskRepository: TaskRepository,
) {
    fun execute() = taskRepository.removeFinishedTasks()
}