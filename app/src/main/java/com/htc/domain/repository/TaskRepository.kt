package com.htc.domain.repository

import com.htc.domain.entity.Task

/**
 * Репозиторий для работы с задачами.
 */
interface TaskRepository {
    /**
     * Возвращает список всех задач.
     */
    fun getTasks(): List<Task>

    /**
     * Устанавливает статус [status] у задачи с идентификатором [id].
     */
    fun setStatus(id: Int, status: Boolean)

    /**
     * Создаёт задачу [task].
     */
    fun createTask(task: Task)

    /**
     * Удаляет все завершённые задачи.
     */
    fun removeFinishedTasks()
}