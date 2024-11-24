package com.bignerdranch.android.azarenkomv_01_03

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.Toast

private lateinit var login:EditText
private lateinit var password:EditText

class FlatBank : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flat_bank)
        login=(findViewById(R.id.logline))
        password=(findViewById(R.id.passline))
    }

    fun enter(view: View) {
        if(login.toString()!="" && password.toString()!="")
        {
            var intent= Intent(this@FlatBank, SquareCounter::class.java)
            startActivity(intent)

        }
        else {
            var toast=Toast.makeText(this,"Введите логин и пароль",Toast.LENGTH_LONG)
            toast.show()
        }
    }

}
