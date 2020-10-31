package com.adhityaprimandhika.do_now

import android.hardware.input.InputManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.adhityaprimandhika.do_now.DB.DoNowDatabase
import com.adhityaprimandhika.do_now.DB.TaskDao
import com.adhityaprimandhika.do_now.model.Task

class TaskAdapter(
    private val listTasks: ArrayList<Task>,
    private val listener: TaskListener
): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        return TaskViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_row_task, parent, false))
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val item = listTasks[position]
        holder.taskTitle.text = item.title
        holder.taskDesc.text = item.desc
        holder.itemView.setOnClickListener{
            listener.OnItemClicked(item)
        }
        holder.btnEdit.setOnClickListener{
            listener.EditItem(item)
        }
        holder.btnDelete.setOnClickListener{
            listener.DeleteItem(item)
        }
    }

    override fun getItemCount(): Int {
        return listTasks.size
    }

    inner class TaskViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var taskTitle: TextView = itemView.findViewById(R.id.task_title)
        var taskDesc: TextView = itemView.findViewById(R.id.task_desc)
        var btnEdit: ImageView = itemView.findViewById(R.id.btn_edit)
        var btnDelete: ImageView = itemView.findViewById(R.id.btn_delete)
    }

    interface TaskListener {
        fun OnItemClicked(task: Task)
        fun EditItem(task: Task)
        fun DeleteItem(task: Task)
    }


}