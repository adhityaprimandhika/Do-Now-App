package com.adhityaprimandhika.do_now

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import com.adhityaprimandhika.do_now.DB.AccountDao
import com.adhityaprimandhika.do_now.DB.DoNowDatabase
import com.adhityaprimandhika.do_now.model.Account

class LoginActivity : AppCompatActivity() {

    private lateinit var database: DoNowDatabase
    private lateinit var dao: AccountDao
    private lateinit var loginUsername: String
    private lateinit var loginPassword: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var etLoginUsername: EditText = findViewById(R.id.et_username)
        var etLoginPassword: EditText = findViewById(R.id.et_password)

        database = DoNowDatabase.getDatabase(applicationContext)
        dao = database.getAccountDao()

        var btnLogin: Button = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener{
            val username = etLoginUsername.text.toString()
            val password = etLoginPassword.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(applicationContext, "Field cannot be empty", Toast.LENGTH_SHORT).show()
            }else {
                loginUsername = username
                loginPassword = password
                loginAccount(loginUsername, loginPassword)
            }
        }

        var btnLoginSignUp: TextView = findViewById(R.id.btn_login_sign_up)
        btnLoginSignUp.setOnClickListener {
            startActivity(Intent(this@LoginActivity, SignUpActivity::class.java))
        }
    }

    private fun loginAccount(username: String, password: String) {
        if (dao.login(username, password).isEmpty()) {
            Toast.makeText(applicationContext, "Invalid credentials", Toast.LENGTH_SHORT).show()
        }else {
            Toast.makeText(applicationContext, "Login succeed", Toast.LENGTH_SHORT).show()
            startActivity(Intent(this@LoginActivity, MainActivity::class.java))
        }
    }
}
