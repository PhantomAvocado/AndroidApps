package com.example.firstassignment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : Fragment() {
    private lateinit var credentialsManager: CredentialsManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.activity_log_in, container, false)

        credentialsManager = CredentialsManager.getInstance()

        val registerNow = view.findViewById<TextView>(R.id.registerNow)
        val emailInputLayout = view.findViewById<TextInputLayout>(R.id.emailInput)
        val passwordInputLayout = view.findViewById<TextInputLayout>(R.id.passwordInputLayout)
        val loginButton = view.findViewById<Button>(R.id.Next)

        registerNow.setOnClickListener {
            Log.d("Onboarding", "Register now pressed")
            // Implement fragment navigation to RegisterFragment
            (activity as MainActivity).replaceFragment(RegisterScreen())
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

        return view
    }

    private fun login(email: String, password: String) {
        val isLoginSuccessful = credentialsManager.login(email, password)

        if (isLoginSuccessful) {
            goToMainActivity()
        } else {
            Toast.makeText(context, "Error", Toast.LENGTH_SHORT).show()
        }
    }

    private fun goToMainActivity() {
        val intent = Intent(context, EmptyMainActivity::class.java)
        startActivity(intent)
    }
}
