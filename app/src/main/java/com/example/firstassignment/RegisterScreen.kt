package com.example.firstassignment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class RegisterScreen : Fragment() {
    private lateinit var credentialsManager: CredentialsManager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.register_screen, container, false)

        credentialsManager = CredentialsManager.getInstance()

        val logIn = view.findViewById<TextView>(R.id.logIn)
        val registerButton = view.findViewById<Button>(R.id.buttonPanel)
        val emailInput = view.findViewById<EditText>(R.id.email_input)
        val passwordInput = view.findViewById<EditText>(R.id.password_input)

        logIn.setOnClickListener {
            Log.d("Homework", "Pressing the 'log in' text")
            (activity as MainActivity).replaceFragment(LogInActivity())
        }

        registerButton.setOnClickListener {
            val email = emailInput.text.toString()
            val password = passwordInput.text.toString()
            registerAccount(email, password)
        }

        return view
    }

    private fun registerAccount(email: String, password: String) {
        val result = credentialsManager.register(email, password)
        if (result == "Registration successful") {
            Toast.makeText(context, result, Toast.LENGTH_SHORT).show()
            (activity as MainActivity).replaceFragment(LogInActivity())
        } else {
            Toast.makeText(context, result, Toast.LENGTH_SHORT).show()
        }
    }
}
