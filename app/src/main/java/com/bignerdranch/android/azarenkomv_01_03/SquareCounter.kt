package com.bignerdranch.android.azarenkomv_01_03

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import com.bignerdranch.android.azarenkomv_01_03.R.*
import com.bignerdranch.android.azarenkomv_01_03.R.id.*
import com.bignerdranch.android.azarenkomv_01_03.ui.theme.Item
import com.google.android.material.snackbar.Snackbar
import java.math.BigDecimal
import java.math.RoundingMode
import com.bignerdranch.android.azarenkomv_01_03.R.id.spinnerl as spinnerl1

private lateinit var metres:EditText
private lateinit var result: TextView
private lateinit var spinner: Spinner
private val apartmentTypes = arrayOf("1-комнатная", "2-комнатная", "3-комнатная", "Студия")
private val pricePerMeter = 120.0

class SquareCounter : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_square_counter)

        metres = (findViewById(id.metres))
        result = (findViewById(forRes))
        spinner = findViewById(id.spinnerl)
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, apartmentTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adapter
    }

    fun backtomenu(view: View) {
        var intent = Intent(this@SquareCounter, CountResult::class.java)
        startActivity(intent)
    }

    fun Count(view: View) {
        val selectedType = spinner.selectedItem.toString()
        val metersText = metres.text.toString()

        if (metersText.isEmpty()) {
            var toast = Toast.makeText(this, "Введите метры", Toast.LENGTH_LONG)
            toast.show()
            return
        }


        val meters = metersText.toDouble()
        val cost = when (selectedType) {
            "1-комнатная" -> pricePerMeter * meters * 1.4
            "2-комнатная" -> pricePerMeter * meters
            "3-комнатная" -> pricePerMeter * meters * 0.8
            "Студия" -> pricePerMeter * meters * 1.1
            else -> 0.0
        }



        result.text = "Результат: ${ BigDecimal(cost/1000).setScale(2, RoundingMode.HALF_UP).toDouble()} тыс. рублей"

        val intent = Intent(this, CountResult::class.java)
        intent.putExtra("COST",  BigDecimal(cost/1000).setScale(2, RoundingMode.HALF_UP).toDouble())
        intent.putExtra("Metres",meters)
        startActivity(intent)
    }

}