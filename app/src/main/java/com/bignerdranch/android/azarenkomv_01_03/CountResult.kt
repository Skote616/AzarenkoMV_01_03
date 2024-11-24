package com.bignerdranch.android.azarenkomv_01_03

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

private lateinit var metresline:TextView
private lateinit var resultline:TextView

class CountResult : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_count_result)
        metresline=findViewById(R.id.forMeters)
        resultline=findViewById(R.id.forRes)

        val cost=intent.getDoubleExtra("COST",0.00)
        val metres=intent.getDoubleExtra("Metres",0.0)

        resultline.text = "Стоимость квартиры: $cost тыс. рублей"
        metresline.text=metres.toString()
    }

    fun ToStart(view: View) {
        var intent= Intent(this@CountResult, FlatBank::class.java)
        startActivity(intent)
    }
}