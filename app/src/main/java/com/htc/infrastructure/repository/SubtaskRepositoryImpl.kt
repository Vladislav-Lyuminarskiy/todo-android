package com.htc.infrastructure.repository

import com.htc.domain.entity.Subtask
import com.htc.domain.repository.SubtaskRepository
import com.htc.infrastructure.dao.SubtaskDao
import com.htc.infrastructure.entity.SubtaskEntity
import io.reactivex.rxjava3.core.Flowable

/**
 * Реализация репозитория для работы с подзадачами.
 */
class SubtaskRepositoryImpl constructor(
    private val subtaskDao: SubtaskDao,
) : SubtaskRepository {
    override fun getSubtasks(taskId: Int): Flowable<List<Subtask>> = subtaskDao
        .getSubtasks(taskId)
        .map { it.map { it.toDomain() } }

    override fun setStatus(id: Int, status: Boolean) = subtaskDao.setStatus(id, status)

    override fun createSubtask(taskId: Int, subtask: Subtask) =
        subtaskDao.createSubtask(SubtaskEntity(taskId, subtask))
}