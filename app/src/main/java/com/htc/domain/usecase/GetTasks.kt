package com.htc.domain.usecase

import com.htc.domain.entity.Task
import com.htc.domain.repository.TaskRepository
import io.reactivex.rxjava3.core.Flowable

/**
 * Сценарий получения списка всех задач.
 */
class GetTasks(
    private val taskRepository: TaskRepository,
) {
    /**
     * Возвращает список всех задач.
     */
    operator fun invoke(): Flowable<List<Task>> = taskRepository.getTasks()
}