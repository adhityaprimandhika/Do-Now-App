package com.adhityaprimandhika.do_now

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.adhityaprimandhika.do_now.DB.DoNowDatabase
import com.adhityaprimandhika.do_now.DB.TaskDao
import com.adhityaprimandhika.do_now.model.Task
import kotlinx.android.synthetic.main.activity_input.*

class InputActivity : AppCompatActivity() {

    val INPUT_TASK_EXTRA = "input_task_extra"
    val EXTRA = "extra"
    private lateinit var task: Task
    private var isUpdate = false
    private lateinit var database: DoNowDatabase
    private lateinit var dao: TaskDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input)

        var btnInput: Button = findViewById(R.id.btn_input)
        var btnBack: ImageView = findViewById(R.id.btn_back)

        database = DoNowDatabase.getDatabase(applicationContext)
        dao = database.getTaskDao()

        if (intent.getParcelableExtra<Task>(INPUT_TASK_EXTRA) != null) {
            isUpdate = true
            task = intent.getParcelableExtra(INPUT_TASK_EXTRA)!!
            input_title.setText(task.title)
            input_desc.setText(task.desc)
        }

        if (intent.getStringExtra(EXTRA) != null) {
            btnInput.text = intent.getStringExtra(EXTRA)
        }

        btnInput.setOnClickListener {
            val title = input_title.text.toString()
            val desc = input_desc.text.toString()

            if (title.isEmpty() || desc.isEmpty()) {
                Toast.makeText(applicationContext, "Task cannot be empty", Toast.LENGTH_SHORT).show()
            }
            else {
                if (isUpdate) {
                    saveTask(Task(id = task.id, title = title, desc = desc))
                }
                else {
                    saveTask(Task(title = title, desc = desc))
                }
            }

            finish()
        }

        btnBack.setOnClickListener {
            startActivity(Intent(this@InputActivity, MainActivity::class.java))
        }
    }

    private fun saveTask(task: Task) {
        if (dao.getById(task.id).isEmpty()) {
            dao.insert(task)
        }
        else {
            dao.update(task)
        }

        Toast.makeText(applicationContext, "Task saved", Toast.LENGTH_SHORT).show()
    }
}
