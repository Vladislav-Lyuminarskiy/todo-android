package com.htc.presentation.taskdetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.CheckBox
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.htc.R
import com.htc.presentation.tasklist.TaskListActivity

class TaskDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_details)

        val taskId = intent.getIntExtra("taskId", -1)
        val task = TaskListActivity.tasks.find { it.id == taskId }

        if (task == null) {
            Toast.makeText(
                this,
                "Задача с указанным идентификатором не существует",
                Toast.LENGTH_LONG
            ).show()

            finish()
        } else {
            val finishedSubtasks = task.subtasks
                .map { it.count { it.status } }
                .blockingSingle()

            findViewById<CheckBox>(R.id.task_status).isChecked = task.status
            findViewById<TextView>(R.id.task_description).text = task.description
            findViewById<TextView>(R.id.task_subtask_count).text =
                "$finishedSubtasks из ${task.subtasks.toList().blockingGet()[0].size}"

            findViewById<RecyclerView>(R.id.recycler_view).apply {
                setHasFixedSize(true)
                layoutManager = LinearLayoutManager(this@TaskDetailsActivity)
                adapter = TaskDetailsAdapter(task) {
                    Toast.makeText(
                        this@TaskDetailsActivity,
                        it.description,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
                Toast.makeText(this, "FAB was clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    companion object {
        fun start(context: Context, taskId: Int) {
            val intent = Intent(context, TaskDetailsActivity::class.java).apply {
                putExtra("taskId", taskId)
            }

            context.startActivity(intent)
        }
    }
}