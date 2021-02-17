package com.example.p5bmicalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEnter = findViewById<Button>(R.id.btnEnter)
        val username = findViewById<TextView>(R.id.txtName)

        btnEnter.setOnClickListener{
            val intent = Intent(this, Cal_BMI::class.java)


            intent.putExtra("name", username.text.toString())
            startActivity(intent)
        }


    }
}