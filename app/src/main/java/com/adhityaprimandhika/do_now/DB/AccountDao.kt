package com.adhityaprimandhika.do_now.DB

import androidx.room.*
import com.adhityaprimandhika.do_now.model.Account

@Dao
interface AccountDao {
    @Insert
    fun insert(account: Account)

    @Update
    fun update(account: Account)

    @Delete
    fun delete(account: Account)

    @Query("SELECT * FROM accounts")
    fun getAll() : List<Account>

    @Query("SELECT * FROM accounts WHERE id = :id")
    fun getById(id: Int) : List<Account>

    @Query("SELECT * FROM accounts WHERE username = :username")
    fun getByUsername(username: String) : List<Account>

    @Query("SELECT * FROM accounts WHERE username = :username AND password = :password")
    fun login(username: String, password: String) : List<Account>
}