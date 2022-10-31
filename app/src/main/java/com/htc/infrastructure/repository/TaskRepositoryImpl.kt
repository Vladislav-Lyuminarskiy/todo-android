package com.htc.infrastructure.repository

import com.htc.domain.entity.Task
import com.htc.domain.repository.TaskRepository
import com.htc.infrastructure.dao.SubtaskDao
import com.htc.infrastructure.dao.TaskDao
import com.htc.infrastructure.entity.TaskEntity
import io.reactivex.rxjava3.core.Flowable

/**
 * Реализация репозитория для работы с задачами.
 */
class TaskRepositoryImpl constructor(
    private val taskDao: TaskDao,
    private val subtaskDao: SubtaskDao,
) : TaskRepository {
    override fun getTasks(): Flowable<List<Task>> = taskDao
        .getTasks()
        .map { list -> list.map { toDomain(it) } }

    override fun setStatus(id: Int, status: Boolean) = taskDao
        .setStatus(id, status)

    override fun createTask(task: Task) = taskDao
        .createTask(TaskEntity(task))

    override fun removeFinishedTasks() = taskDao
        .removeFinishedTasks()

    private fun toDomain(entity: TaskEntity): Task = Task(
        id = entity.id,
        description = entity.description,
        status = entity.status,
        subtasks = subtaskDao
            .getSubtasks(entity.id)
            .map { it.map { it.toDomain() } }
    )
}