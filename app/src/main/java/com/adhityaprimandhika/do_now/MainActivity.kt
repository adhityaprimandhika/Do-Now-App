package com.adhityaprimandhika.do_now

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.adhityaprimandhika.do_now.DB.DoNowDatabase
import com.adhityaprimandhika.do_now.model.Task
import kotlinx.android.synthetic.main.activity_input.view.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getTasksData()

        fab.setOnClickListener {
            startActivity(Intent(this@MainActivity, InputActivity::class.java))
        }
    }

    private fun getTasksData(){
        val database = DoNowDatabase.getDatabase(applicationContext)
        val dao = database.getTaskDao()
        val listTasks = arrayListOf<Task>()
        listTasks.addAll(dao.getAll())
        setupRecyclerView(listTasks)
    }

    private fun setupRecyclerView(listTasks: ArrayList<Task>){
        rv_tasks.apply {
            adapter = TaskAdapter(listTasks, object : TaskAdapter.TaskListener{
                override fun OnItemClicked(task: Task) {
                    val intent = Intent(this@MainActivity, InputActivity::class.java)
                    intent.putExtra(InputActivity().INPUT_TASK_EXTRA, task)
                    startActivity(intent)
                }

                override fun EditItem(task: Task) {
                    val intent = Intent(this@MainActivity, InputActivity::class.java)
                    intent.putExtra(InputActivity().INPUT_TASK_EXTRA, task)
                    intent.putExtra(InputActivity().EXTRA, "Edit Task")
                    startActivity(intent)
                }

                override fun DeleteItem(task: Task) {
                    val intent = Intent(this@MainActivity, DeleteActivity::class.java)
                    intent.putExtra(DeleteActivity().DELETE_TASK_EXTRA, task)
                    startActivity(intent)
                }
            })

            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    override fun onResume() {
        super.onResume()
        getTasksData()
    }
}