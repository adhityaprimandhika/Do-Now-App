package com.adhityaprimandhika.do_now

import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var taskAdapter: TaskAdapter
    private lateinit var rvTasks: RecyclerView
    private var addTaskList: MutableList<Task> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAdd: ImageView = findViewById(R.id.btn_add)
        btnAdd.setOnClickListener(this)
        rvTasks = findViewById(R.id.rv_tasks)
        rvTasks.setHasFixedSize(true)

        initView()
    }

    fun initView() {
        rvTasks.layoutManager = LinearLayoutManager(this)
        taskAdapter = TaskAdapter(this)
        rvTasks.adapter = taskAdapter
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_add -> {
                val dialog: AlertDialog.Builder = AlertDialog.Builder(this)
                val view: View = layoutInflater.inflate(R.layout.activity_input_task, null)
                val addTitle: EditText = view.findViewById(R.id.add_title)
                val addDesc: EditText = view.findViewById(R.id.add_desc)
                dialog.setView(view)
                dialog.setPositiveButton("Add") {_: DialogInterface, _: Int ->
                    if (addTitle.text.isNotEmpty() && addDesc.text.isNotEmpty()) {
                        var title: String = addTitle.text.toString()
                        var desc: String = addDesc.text.toString()
                        addTaskList.add(Task("$title", "$desc"))
                        taskAdapter.setTasks(addTaskList)
                    }
                }
                dialog.setNegativeButton("Cancel") {_: DialogInterface, _: Int ->

                }
                dialog.show()
            }
        }
    }
}