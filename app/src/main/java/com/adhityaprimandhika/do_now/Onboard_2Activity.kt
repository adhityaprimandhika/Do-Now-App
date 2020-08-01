package com.adhityaprimandhika.do_now

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_onboard.*

class Onboard_2Activity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboard)

        img_onboard.setImageResource(R.drawable.plan)
        tv_title.text = "Make your life well planned"

        val btnNextOnboard : Button = findViewById(R.id.btn_next_onboard)
        btnNextOnboard.setOnClickListener(this)
        val btnBackOnboard : Button = findViewById(R.id.btn_back_onboard)
        btnBackOnboard.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id) {
            R.id.btn_next_onboard -> {
                var nextIntent = Intent(this@Onboard_2Activity, Onboard_3Activity::class.java)
                startActivity(nextIntent)
            }
            R.id.btn_back_onboard -> {
                var backIntent = Intent(this@Onboard_2Activity, Onboard_1Activity::class.java)
                startActivity(backIntent)
            }
        }
    }
}
