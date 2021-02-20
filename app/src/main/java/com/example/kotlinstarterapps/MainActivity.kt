package com.example.kotlinstarterapps

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener{
            click()
        }
    }

    fun click(){
//        val et = findViewById<TextView>(R.id.et)
//        val tv= findViewById<TextView>(R.id.tv)


        val x = Integer.parseInt(et.text.toString())
        val y = Calendar.getInstance().get(Calendar.YEAR)
        val z = x-y
        tv.text ="$z years ols !"
    }


}