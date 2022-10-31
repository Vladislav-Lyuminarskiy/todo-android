package com.htc.presentation.tasklist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.htc.R
import com.htc.domain.entity.Subtask
import com.htc.domain.entity.Task
import com.htc.presentation.taskdetails.TaskDetailsActivity
import io.reactivex.rxjava3.core.Flowable
import kotlin.random.Random

class TaskListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_task_list)

        findViewById<RecyclerView>(R.id.recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(this@TaskListActivity)
            adapter = TaskListAdapter(tasks) {
                Toast.makeText(
                    this@TaskListActivity,
                    it.description,
                    Toast.LENGTH_SHORT
                ).show()

                TaskDetailsActivity.start(this@TaskListActivity, it.id)
            }
        }


        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener {
            Toast.makeText(this, "FAB was clicked", Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        val tasks: List<Task> by lazy {
            // TODO: Заменить фейковые данные на реальные.
            val tasks: MutableList<Task> = mutableListOf()
            for (i in 1..20) {
                val subtasks: MutableList<Subtask> = mutableListOf()
                val subtaskCount = Random.nextInt(4)
                for (j in 1..subtaskCount) {
                    subtasks.add(Subtask(
                        id = i + j,
                        description = "Subtask $i",
                        status = Random.nextBoolean()
                    ))
                }

                tasks.add(Task(
                    id = i,
                    description = "Task $i",
                    status = Random.nextBoolean(),
                    Flowable.empty()
                ))
            }

            tasks
        }
    }
}