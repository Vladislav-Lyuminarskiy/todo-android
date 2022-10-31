package com.htc.presentation.taskdetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.htc.R
import com.htc.domain.entity.Subtask
import com.htc.domain.entity.Task

typealias OnItemClickListener = (subtask: Subtask) -> Unit

class TaskDetailsAdapter(
    private val task: Task,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<TaskDetailsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.layout_item_subtask, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(task.subtasks.blockingFirst()[position], listener)
    }

    override fun getItemCount(): Int = task.subtasks.toList().blockingGet()[0].size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val status: CheckBox = itemView.findViewById(R.id.subtask_status)
        val description: TextView = itemView.findViewById(R.id.subtask_description)

        fun bind(subtask: Subtask, listener: OnItemClickListener) {
            status.isChecked = subtask.status
            description.text = subtask.description

            itemView.setOnClickListener { listener(subtask) }
        }
    }
}