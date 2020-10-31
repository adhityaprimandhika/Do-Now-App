package com.adhityaprimandhika.do_now

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import com.adhityaprimandhika.do_now.DB.DoNowDatabase
import com.adhityaprimandhika.do_now.DB.TaskDao
import com.adhityaprimandhika.do_now.model.Task
import kotlinx.android.synthetic.main.activity_input.*

class DeleteActivity : AppCompatActivity() {

    lateinit var handler: Handler
    val DELETE_TASK_EXTRA = "delete_task_extra"
    private lateinit var task: Task
    private lateinit var database: DoNowDatabase
    private lateinit var dao: TaskDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_delete)

        database = DoNowDatabase.getDatabase(applicationContext)
        dao = database.getNoteDao()
        if (intent.getParcelableExtra<Task>(DELETE_TASK_EXTRA) != null) {
            task = intent.getParcelableExtra(DELETE_TASK_EXTRA)
        }
        deleteTask(task)

        handler = Handler()
        handler.postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

    private fun deleteTask(task: Task) {
        dao.delete(task)
        Toast.makeText(applicationContext, "Task deleted", Toast.LENGTH_SHORT).show()
    }
}
