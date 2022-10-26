package com.htc.presentation.taskdetails

import androidx.lifecycle.ViewModel
import com.htc.domain.entity.Subtask

class TaskDetailsViewModel: ViewModel() {
    data class TaskDetailsUiState(
        /**
         * Описание задачи.
         */
        val description: String = "",
        /**
         * Завершённость задачи.
         */
        val state: Boolean = false,
        /**
         * Список подзадач.
         */
        val subtasks: List<Subtask> = emptyList(),
        /**
         * Признак того, что приложение находится в процессе загрузки данных.
         */
        val showLoading: Boolean = false,
    )

    private val uiState = TaskDetailsUiState()
}