package com.example.bminew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        button_click()
        calculateMeter()
    }
    fun calculateBmi():Double{
        var wt: Double=(edtWt.getText().toString().toDouble())
        var ht: Double=(edtHt.getText().toString().toDouble())
        var bmi=((wt/ht))/ht
        return bmi
    }
    fun calculateMeter(){
        btnCalMeter.setOnClickListener {
            var ft:Double=edtFeet.getText().toString().toDouble()
            var mt:Double?=null
            mt=ft/3.28
            txtMeter.setText(mt.toString())
        }

    }
    fun button_click(){
        btnCalBmi.setOnClickListener {
            val intent= Intent(this@MainActivity,bmiresultapp::class.java)
            intent.putExtra("BMIResult",calculateBmi())
            startActivity(intent)
        }
    }
}
