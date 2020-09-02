package com.amannirala13.mobilesiu.assignments.asg1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.amannirala13.mobilesiu.R
import kotlinx.android.synthetic.main.activity_asg1_first.*

class Asg1First : AppCompatActivity() {

    private var msg: String? = null

    companion object{
        const val ASG1_INTENT_MESSAGE = "ASG1_MESSAGE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_asg1_first)

        asg1_first_send_btn.setOnClickListener {
            msg = asg1_first_message_text.text.toString()
            if(msg.isNullOrEmpty())
                Toast.makeText(this, "Please enter some message!", Toast.LENGTH_SHORT).show()
            else{
                val intent = Intent(this, Asg1Second::class.java)
                intent.putExtra(ASG1_INTENT_MESSAGE, msg)
                startActivity(intent) }
        }

        asg1_first_close_btn.setOnClickListener { finish() }

    }
}