package com.htc.presentation.tasklist

import androidx.lifecycle.ViewModel
import com.htc.domain.entity.Task

class TaskListViewModel : ViewModel() {
    data class TaskListUiState(
        /**
         * Список задач.
         */
        val tasks: List<Task> = emptyList(),
        /**
         * Признак того, что приложение находится в процессе загрузки данных.
         */
        val showLoading: Boolean = false,
    )

    private val uiState = TaskListUiState()
}