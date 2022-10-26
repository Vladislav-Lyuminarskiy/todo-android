package com.htc.infrastructure.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import com.htc.infrastructure.entity.SubtaskEntity

@Dao
interface SubtaskDao {
    /**
     * Возвращает список всех подзадач у задачи с идентификатором [taskId].
     */
    @Query("SELECT * FROM subtasks WHERE taskId=:taskId")
    fun getSubtasks(taskId: Int): List<SubtaskEntity>

    /**
     * Устанавливает завершённость [status] у подзадачи с идентификатором [id].
     */
    @Query("UPDATE subtasks SET status=:status WHERE id=:id")
    fun setStatus(id: Int, status: Boolean)

    /**
     * Создаёт подзадачу [subtask].
     */
    @Insert(onConflict = REPLACE)
    fun createSubtask(subtask: SubtaskEntity)
}