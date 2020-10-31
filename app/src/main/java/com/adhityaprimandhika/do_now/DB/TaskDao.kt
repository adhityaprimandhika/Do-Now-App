package com.adhityaprimandhika.do_now.DB

import androidx.room.*
import com.adhityaprimandhika.do_now.model.Task

@Dao
interface TaskDao {

    @Insert
    fun insert(task: Task)

    @Update
    fun update(task: Task)

    @Delete
    fun delete(task: Task)

    @Query("SELECT * FROM tasks")
    fun getAll() : List<Task>

    @Query("SELECT * FROM tasks WHERE id = :id")
    fun getById(id: Int) : List<Task>
}