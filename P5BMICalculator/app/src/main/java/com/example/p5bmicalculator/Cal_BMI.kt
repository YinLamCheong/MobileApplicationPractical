package com.example.p5bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Cal_BMI:AppCompatActivity() {
    var bmiIndex:Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.cal_bmi)

        val bundle:Bundle? = intent.extras
        val userName = bundle!!.getString("name")
        val tv = findViewById<TextView>(R.id.tvWelcome)
        tv.text = userName

        if(savedInstanceState != null){
            bmiIndex = savedInstanceState.getDouble("BMIIndex")

            val status = findViewById<TextView>(R.id.tvStatus)
            status.text = getStatus()
        }

        val btncal = findViewById<Button>(R.id.btnCalBMI)
        btncal.setOnClickListener {
            val height= findViewById<TextView>(R.id.inpHeight).text.toString()
            val weight= findViewById<TextView>(R.id.inpWeight).text.toString()
            val status = findViewById<TextView>(R.id.tvStatus)

            bmiIndex = weight.toDouble()/(height.toDouble()*height.toDouble())

            status.text = getStatus()
        }

    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putDouble("BMIIndex", bmiIndex)
    }

    private fun getStatus():String{
        return when {
            bmiIndex < 18.5 -> "Underweight"
            bmiIndex <= 24.9 -> "Normal Weight"
            bmiIndex <= 29.9 -> "Overweight"
            bmiIndex <= 34.9 -> "Obesity class I"
            bmiIndex <= 39.9 -> "Obesity class II"
            else -> "Obesity class III"
        }

    }


}