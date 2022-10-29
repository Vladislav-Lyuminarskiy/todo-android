package com.htc.domain.repository

import com.htc.domain.entity.Task
import io.reactivex.rxjava3.core.Flowable

/**
 * Репозиторий для работы с задачами.
 */
interface TaskRepository {
    /**
     * Возвращает список всех задач.
     */
    fun getTasks(): Flowable<List<Task>>

    /**
     * Устанавливает завершённость [status] у задачи с идентификатором [id].
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