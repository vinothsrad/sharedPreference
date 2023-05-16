package com.example.sharedpreference

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPref = getSharedPreferences("myPref", MODE_PRIVATE)
        val editor =sharedPref.edit()
        val save=findViewById<Button>(R.id.btnSave)
        val load=findViewById<Button>(R.id.btnLoad)
        val  userName=findViewById<TextView>(R.id.tvUsername)
        val  email=findViewById<TextView>(R.id.tvEmail)
        val  text1=findViewById<EditText>(R.id.edtEmail)
        val  text2=findViewById<EditText>(R.id.edtUsername)


        save.setOnClickListener {
            val usereName = text2.text.toString()
            val emaile = text1.text.toString()

            editor.apply {
                putString("user_name",usereName)
                putString("email",emaile)
                apply()
            }
    }

        load.setOnClickListener {

            val userNamee = sharedPref.getString("user_name","No Saved  User Name")
            val emaiel = sharedPref.getString("email",null)

            userName.text = userNamee
            email.text=emaiel
        }
}}