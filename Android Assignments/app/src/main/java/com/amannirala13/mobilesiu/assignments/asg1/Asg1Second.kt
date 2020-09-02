package com.amannirala13.mobilesiu.assignments.asg1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.amannirala13.mobilesiu.R
import com.amannirala13.mobilesiu.assignments.asg1.Asg1First.Companion.ASG1_INTENT_MESSAGE
import kotlinx.android.synthetic.main.activity_asg1_second.*

class Asg1Second : AppCompatActivity() {

    private var msg: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asg1_second)

        msg = intent.getStringExtra(ASG1_INTENT_MESSAGE)
        asg1_second_message_text.text = msg
        asg1_second_close_btn.setOnClickListener{finish()}
    }
}