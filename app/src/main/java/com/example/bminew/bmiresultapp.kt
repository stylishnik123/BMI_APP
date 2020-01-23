package com.example.bminew

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bmiresultapp.*
import java.text.DecimalFormat

class bmiresultapp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bmiresultapp)
        showBMIResult()
        findBMICategory()
        setExitListener()
        setCheckAgainListener()
    }
    fun showBMIResult(){
        var decFormat = DecimalFormat("#.#")
       // var forBMI=decFormat.format(getIntent().getExtras().getDouble("BMIResult"))
        var forBMI=intent.extras ?:return
        var forbmi=forBMI.getDouble("BMIResult")
        lblBmiResult.setText(forbmi.toString())
    }
    fun findBMICategory(){
        var categoryOfBMI="unknown"
      //  var resultBMI=getIntent().getExtras().getDouble("BMIResult")
        var forBMI=intent.extras ?:return
        var resultBMI=forBMI.getDouble("BMIResult")
        if(resultBMI < 15){
            categoryOfBMI="Very Severely UnderWeight"
        }
        else if(resultBMI in 15..16){
            categoryOfBMI="Severely UnderWeight"
        }
        else if(resultBMI > 16 && resultBMI <= 18.5){
            categoryOfBMI="Under Weight"
        }
        else if(resultBMI > 18.5 && resultBMI <= 25){
            categoryOfBMI="Normal (Healty Weight)"
        }
        else if(resultBMI in 25..30){
            categoryOfBMI="OverWeight"
        }
        else if(resultBMI in 30..35){
            categoryOfBMI="Moderrately Obese"
        }
        else if(resultBMI in 35..40){
            categoryOfBMI="Severely Obese"
        }
        else if(resultBMI >=40){
            categoryOfBMI="Very Severely Obese"
        }
        lblBmiResultCategory.setText(categoryOfBMI)
    }
    fun setExitListener(){
        btnExit.setOnClickListener {
            this.finish()
        }
    }
    fun setCheckAgainListener(){
        btnChkAgain.setOnClickListener {
            val intent= Intent(this@bmiresultapp,MainActivity::class.java)
            startActivity(intent)
        }
    }
}
