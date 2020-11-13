package com.adhityaprimandhika.do_now

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.adhityaprimandhika.do_now.DB.AccountDao
import com.adhityaprimandhika.do_now.DB.DoNowDatabase
import com.adhityaprimandhika.do_now.model.Account

class SignUpActivity : AppCompatActivity() {

    private lateinit var database: DoNowDatabase
    private lateinit var dao: AccountDao
    private var isExist = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var btnSignUp: Button = findViewById(R.id.btn_sign_up)
        var etUsername: EditText = findViewById(R.id.et_username_sign_up)
        var etEmail: EditText = findViewById(R.id.et_email_sign_up)
        var etPassword: EditText = findViewById(R.id.et_password_sign_up)

        database = DoNowDatabase.getDatabase(applicationContext)
        dao = database.getAccountDao()

        btnSignUp.setOnClickListener {
            val username = etUsername.text.toString()
            val email = etEmail.text.toString()
            val password = etPassword.text.toString()

            if (dao.getByUsername(username).isNotEmpty()) {
                isExist = true
            }

            if (username.isEmpty() || email.isEmpty() || password.isEmpty()) {
                Toast.makeText(applicationContext, "Field cannot be empty", Toast.LENGTH_SHORT).show()
            }
            else {
                if (isExist) {
                    Toast.makeText(applicationContext, "Try another username", Toast.LENGTH_SHORT).show()
                }
                else {
                    createAccount(Account(username = username, email = email, password = password))
                    Toast.makeText(applicationContext, "Account created", Toast.LENGTH_SHORT).show()
                    startActivity(Intent(this@SignUpActivity, MainActivity::class.java))
                }
            }


        }
    }

    private fun createAccount(account: Account) {
        dao.insert(account)
        Toast.makeText(applicationContext, "Account created", Toast.LENGTH_SHORT).show()
    }
}
