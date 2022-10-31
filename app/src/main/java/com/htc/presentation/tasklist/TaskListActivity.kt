package com.htc.presentation.tasklist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.htc.R
import com.htc.domain.entity.Task
import io.reactivex.rxjava3.core.Flowable

class TaskListActivity : AppCompatActivity() {
    // TODO: Заменить тестовые данные на реальные.
    val tasks: List<Task> = listOf(
        Task(1, "Task 1", false, Flowable.empty()),
        Task(2, "Task 2", true, Flowable.empty()),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = TaskListAdapter(tasks) {
            Toast.makeText(this, it.description, Toast.LENGTH_SHORT).show()
        }

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            Toast.makeText(this, "FAB was clicked", Toast.LENGTH_SHORT).show()
        }
    }
}