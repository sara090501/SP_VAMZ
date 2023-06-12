package com.example.kvizzz.activity

import AddCategoryFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.kvizzz.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playButton: Button = findViewById(R.id.play)
        playButton.setOnClickListener {
            // Create an instance of the fragment
            val fragmentMenu = MenuFragment()
            val fragmentAddCategory = AddCategoryFragment()

            // Get the FragmentManager
            val fragmentManager = supportFragmentManager

            // Begin a transaction to add the fragment to the container
            val transaction = fragmentManager.beginTransaction()
            transaction.add(R.id.myNavHostFragment, fragmentMenu)
            transaction.hide(fragmentAddCategory)
            transaction.commit()
        }

        val exit: ImageView = findViewById(R.id.exit)
        exit.setOnClickListener {
            onDestroy()
        }

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}