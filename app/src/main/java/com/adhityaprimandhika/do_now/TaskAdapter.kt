package com.adhityaprimandhika.do_now

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class TaskAdapter(context: Context): RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {

    private val list : MutableList<Task> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, i: Int): TaskViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_task, parent, false)
        return TaskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bindModel(list[position])
    }

    fun setTasks(data: List<Task>) {
        list.clear()
        list.addAll(data)
        notifyDataSetChanged()
    }

    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var taskTitle : TextView = itemView.findViewById(R.id.task_title)
        var taskDesc : TextView = itemView.findViewById(R.id.task_desc)
        fun bindModel (t: Task) {
            taskTitle.text = t.getTitle()
            taskDesc.text = t.getDesc()
        }
    }
}