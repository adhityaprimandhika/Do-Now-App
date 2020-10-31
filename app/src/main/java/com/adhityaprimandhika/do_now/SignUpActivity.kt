package com.adhityaprimandhika.do_now

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        var btnSignUp : Button = findViewById(R.id.btn_sign_up)
        btnSignUp.setOnClickListener {
            var signUpIntent = Intent(this@SignUpActivity, MainActivity::class.java)
            startActivity(signUpIntent)
        }
    }
}
