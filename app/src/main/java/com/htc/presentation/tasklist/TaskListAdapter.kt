package com.htc.presentation.tasklist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.htc.R
import com.htc.domain.entity.Task

typealias OnItemClickListener = (task: Task) -> Unit

class TaskListAdapter(
    private val tasks: List<Task>,
    private val listener: OnItemClickListener,
) : RecyclerView.Adapter<TaskListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.layout_item_task, null)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tasks[position], listener)
    }

    override fun getItemCount() = tasks.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val status: CheckBox = itemView.findViewById(R.id.task_status)
        val description: TextView = itemView.findViewById(R.id.task_description)
        val subtaskCount: TextView = itemView.findViewById(R.id.task_subtask_count)

        fun bind(task: Task, listener: OnItemClickListener) {
            val finishedSubtasks = task.subtasks
                .map { it.filter { it.status } }
                .count()
                .blockingGet()

            status.isChecked = task.status
            description.text = task.description
            subtaskCount.text = "$finishedSubtasks из ${task.subtasks.count().blockingGet()}"

            itemView.setOnClickListener { listener(task) }
        }
    }

}