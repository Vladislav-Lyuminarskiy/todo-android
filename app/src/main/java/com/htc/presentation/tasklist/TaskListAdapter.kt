package com.htc.presentation.tasklist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.htc.R
import com.htc.domain.entity.Task

class TaskListAdapter(
    private val tasks: List<Task>
) : RecyclerView.Adapter<TaskListAdapter.TaskListViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.layout_item_task, null)

        return TaskListViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {
        val task = tasks[position]
        val finishedSubtasks = task.subtasks
            .map { it.filter { it.status } }
            .count()

        with(holder) {
            status.isChecked = task.status
            description.text = task.description
            subtaskCount.text = "$finishedSubtasks/${task.subtasks.count()}"
        }
    }

    override fun getItemCount() = tasks.size

    class TaskListViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val status: CheckBox = itemView.findViewById(R.id.task_status)
        val description: TextView = itemView.findViewById(R.id.task_description)
        val subtaskCount: TextView = itemView.findViewById(R.id.task_subtask_count)
    }
}