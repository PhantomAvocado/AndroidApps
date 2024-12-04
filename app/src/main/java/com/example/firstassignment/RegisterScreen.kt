package com.example.firstassignment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

//given proper credentials, create an account

class RegisterScreen : AppCompatActivity() {
    private val credentialsManager = CredentialsManager()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_screen)


        val logIn = findViewById<TextView>(R.id.logIn)
        val registerButton = findViewById<Button>(R.id.buttonPanel)
        val emailInput = findViewById<EditText>(R.id.email_input)
        val passwordInput = findViewById<EditText>(R.id.password_input)

        logIn.setOnClickListener {
            Log.d("Homework","Pressing the 'log in' text")
            navigateToLogin()
        }

        registerButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()
            registerAccount(email, password)
        }
    }

    private fun navigateToLogin() {
        val goToLogInIntent = Intent(this, LogInActivity::class.java)
        startActivity(goToLogInIntent)
    }

    private fun registerAccount(email: String, password: String) {
        val result = credentialsManager.register(email, password)
        if (result == "Registration successful") {
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            navigateToLogin()
        } else {
            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
            val goToLogInIntent = Intent(this,LogInActivity::class.java)
            startActivity(goToLogInIntent)
        }
    }
}
