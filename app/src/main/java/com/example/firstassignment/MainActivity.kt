package com.example.firstassignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private var showingFragmentA = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, FragmentA()).commit()

        val toggleButton: Button = findViewById(R.id.toggleButton)
        toggleButton.setOnClickListener {
            if (showingFragmentA) {
                replaceFragment(FragmentB())
            } else {
                replaceFragment(FragmentA())
            }
            showingFragmentA = !showingFragmentA
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
    }
}
