package com.htc.infrastructure.repository

import com.htc.domain.entity.Task
import com.htc.domain.repository.TaskRepository
import com.htc.infrastructure.dao.SubtaskDao
import com.htc.infrastructure.dao.TaskDao
import com.htc.infrastructure.entity.TaskEntity

/**
 * Реализация репозитория для работы с задачами.
 */
class TaskRepositoryImpl constructor(
    private val taskDao: TaskDao,
    private val subtaskDao: SubtaskDao,
) : TaskRepository {
    override fun getTasks(): List<Task> = taskDao
        .getTasks()
        .map {
            Task(
                id = it.id,
                description = it.description,
                status = it.status,
                subtasks = subtaskDao
                    .getSubtasks(it.id)
                    .map { it.toDomain() }
            )
        }

    override fun setStatus(id: Int, status: Boolean) = taskDao.setStatus(id, status)

    override fun createTask(task: Task) = taskDao.createTask(TaskEntity(task))

    override fun removeFinishedTasks() = taskDao.removeFinishedTasks()
}