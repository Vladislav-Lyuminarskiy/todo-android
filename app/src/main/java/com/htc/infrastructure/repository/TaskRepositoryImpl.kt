package com.htc.infrastructure.repository

import com.htc.domain.entity.Task
import com.htc.domain.repository.TaskRepository
import com.htc.infrastructure.dao.TaskDao
import com.htc.infrastructure.entity.TaskEntity

/**
 * Реализация репозитория для работы с задачами.
 */
class TaskRepositoryImpl constructor(
    private val taskDao: TaskDao
) : TaskRepository {
    override fun getTasks(): List<Task> = taskDao
        .getTasks()
        .map { it.toDomain() }

    override fun setStatus(id: Int, status: Boolean) = taskDao.setStatus(id, status)

    override fun createTask(task: Task) = taskDao.createTask(TaskEntity(task))

    override fun removeFinishedTasks() = taskDao.removeFinishedTasks()
}