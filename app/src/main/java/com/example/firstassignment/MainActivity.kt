package com.example.firstassignment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    private lateinit var credentialsManager: CredentialsManager

    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        credentialsManager = CredentialsManager()

        val registerNow = findViewById<TextView>(R.id.registerNow)
        val emailInputLayout = findViewById<TextInputLayout>(R.id.emailInput)
        val passwordInputLayout = findViewById<TextInputLayout>(R.id.passwordInputLayout)
        val loginButton = findViewById<Button>(R.id.Next)

        registerNow.setOnClickListener {
            Log.d("Onboarding", "Register now pressed")

            val goToRegistrationIntent = Intent(this@MainActivity, RegisterScreen::class.java)
            startActivity(goToRegistrationIntent)
        }

        loginButton.setOnClickListener {
            val email = emailInputLayout.editText?.text.toString()
            val password = passwordInputLayout.editText?.text.toString()

            if (!credentialsManager.isEmailValid(email)) {
                emailInputLayout.error = "Enter correct email"
                return@setOnClickListener
            } else {
                emailInputLayout.error = null
            }

            if (!credentialsManager.isPasswordValid(password)) {
                passwordInputLayout.error =
                    "Password must be at least 8 characters, include a digit and a special character"
                return@setOnClickListener
            } else {
                passwordInputLayout.error = null
            }

            login(email, password)
        }
    }

    private fun goToMainActivity() {
        val intent = Intent(this, EmptyMainActivity::class.java)
        startActivity(intent)
    }

    private fun login(email: String, password: String) {
        val isLoginSuccessful = credentialsManager.login(email, password)

        if (isLoginSuccessful) {
            goToMainActivity()
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
        }
    }
}
