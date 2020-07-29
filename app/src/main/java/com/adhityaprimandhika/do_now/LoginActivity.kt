package com.adhityaprimandhika.do_now

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.style.ClickableSpan
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var btnLoginSignUp: TextView = findViewById(R.id.btn_login_sign_up)
        btnLoginSignUp.setOnClickListener(this)

        var btnLogin: Button = findViewById(R.id.btn_login)
        btnLogin.setOnClickListener(this)

    }
    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_login -> {
                val loginIntent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(loginIntent)
            }
            R.id.btn_login_sign_up -> {
                val loginSignUpIntent = Intent(this@LoginActivity, SignUpActivity::class.java)
                startActivity(loginSignUpIntent)
            }
        }
    }
}
