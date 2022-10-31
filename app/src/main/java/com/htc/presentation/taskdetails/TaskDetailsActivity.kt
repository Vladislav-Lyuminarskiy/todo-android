package com.htc.presentation.taskdetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.htc.R
import com.htc.presentation.tasklist.TaskListActivity

class TaskDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_details)

        val taskId = intent.getIntExtra("taskId", -1)
        val task = TaskListActivity.tasks.find { it.id == taskId }

        if (task == null || taskId == -1) {
            Toast.makeText(
                this,
                "Задача с указанным идентификатором не существует",
                Toast.LENGTH_LONG
            ).show()

            finish()
        }

        findViewById<TextView>(R.id.toolbar_title).text = task?.description
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