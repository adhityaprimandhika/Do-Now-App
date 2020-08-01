package com.adhityaprimandhika.do_now

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_onboard.*

class Onboard_1Activity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start_onboard)

        img_onboard.setImageResource(R.drawable.task)
        tv_title.text = "Make your task organized"

        val btnNextOnboard : Button = findViewById(R.id.btn_next_onboard)
        btnNextOnboard.setOnClickListener{
            var nextIntent = Intent(this@Onboard_1Activity, Onboard_2Activity::class.java)
            startActivity(nextIntent)
        }
    }
}
