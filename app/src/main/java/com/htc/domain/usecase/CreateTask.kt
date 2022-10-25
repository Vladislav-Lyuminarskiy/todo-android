package com.htc.domain.usecase

import com.htc.domain.entity.Task
import com.htc.domain.repository.TaskRepository

class CreateTask(
    private val taskRepository: TaskRepository,
) {
    fun execute(description: String) = taskRepository.createTask(
        Task(
            id = 0,
            description = description,
            status = false,
            subtasks = emptyList()
        )
    )
}