package com.htc.domain.repository

import com.htc.domain.entity.Subtask

/**
 * Репозиторий для работы с подзадачами.
 */
interface SubtaskRepository {
    /**
     * Возвращает список всех подзадач у задачи с идентификатором [taskId].
     */
    fun getSubtasks(taskId: Int): List<Subtask>

    /**
     * Устанавливает завершённость [status] у подзадачи с идентификатором [id].
     */
    fun setStatus(id: Int, status: Boolean)

    /**
     * Создаёт подзадачу [subtask] у задачи с идентификатором [taskId].
     */
    fun createSubtask(taskId: Int, subtask: Subtask)
}