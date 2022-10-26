package com.htc.infrastructure.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.htc.infrastructure.entity.TaskEntity

@Dao
interface TaskDao {
    /**
     * Возвращает список всех задач.
     */
    @Query("SELECT * FROM tasks")
    fun getTasks(): List<TaskEntity>

    /**
     * Устанавливает завершённость [status] у задачи с идентификатором [id].
     */
    @Query("UPDATE tasks SET status=:status WHERE id=:id")
    fun setStatus(id: Int, status: Boolean)

    /**
     * Создаёт задачу [task].
     */
    @Insert(onConflict = REPLACE)
    fun createTask(task: TaskEntity)

    /**
     * Удаляет все завершённые задачи.
     */
    @Query("DELETE FROM tasks WHERE status=0")
    fun removeFinishedTasks()
}