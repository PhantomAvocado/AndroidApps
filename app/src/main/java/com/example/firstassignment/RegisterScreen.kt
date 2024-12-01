package com.example.firstassignment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

//given proper credentials, create an account

class RegisterScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_screen)


        val logIn = findViewById<TextView>(R.id.logIn)
        logIn.setOnClickListener {
            Log.d("Homework","Pressing the 'log in' text")

            val goToLogInIntent = Intent(this,LogInActivity::class.java)
            startActivity(goToLogInIntent)
        }
    }
}
