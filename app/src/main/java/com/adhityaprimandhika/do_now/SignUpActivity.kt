package com.adhityaprimandhika.do_now

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.adhityaprimandhika.do_now.model.realm.User
import io.realm.Realm
import io.realm.exceptions.RealmException
import io.realm.kotlin.createObject
import kotlinx.android.synthetic.main.activity_sign_up.*

class SignUpActivity : AppCompatActivity() {

    lateinit var realm : Realm
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        initRealm()
        var btnSignUp : Button = findViewById(R.id.btn_sign_up)
        btnSignUp.setOnClickListener {
            realm.beginTransaction()
            try {
                val user = realm.createObject(User::class.java)
                user.setUsername(et_username_sign_up.text.toString())
                user.setEmail(et_email_sign_up.text.toString())
                user.setPassword(et_password_sign_up.text.toString())

                realm.commitTransaction()

                var onboardIntent = Intent(this@SignUpActivity, MainActivity::class.java)
                startActivity(onboardIntent)
            }catch (e : RealmException) {
                Toast.makeText(this, e.message, Toast.LENGTH_SHORT).show()
            }

        }
    }
    fun initRealm() {
        realm = Realm.getDefaultInstance()
    }
}
