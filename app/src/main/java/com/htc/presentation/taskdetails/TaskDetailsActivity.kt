package com.htc.presentation.taskdetails

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.htc.R

class TaskDetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_details)
    }

    companion object {
        fun start(context: Context) {
            val intent = Intent(context, TaskDetailsActivity::class.java)
            context.startActivity(intent)
        }
    }
}