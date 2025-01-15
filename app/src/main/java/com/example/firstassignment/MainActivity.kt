package com.example.firstassignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            val loginFragment = LogInActivity()
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_view, loginFragment)
                .commit()
        }
    }

    fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view, fragment)
            .addToBackStack(null)
            .commit()
    }

    fun showRecipeFragment() {
        val recipeFragment = Recipe()
        replaceFragment(recipeFragment)
    }
}
