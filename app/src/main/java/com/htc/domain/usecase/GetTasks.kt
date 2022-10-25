package com.htc.domain.usecase

import com.htc.domain.entity.Task
import com.htc.domain.repository.TaskRepository

class GetTasks(
    private val taskRepository: TaskRepository,
) {
    fun execute(): List<Task> = taskRepository.getTasks()
}