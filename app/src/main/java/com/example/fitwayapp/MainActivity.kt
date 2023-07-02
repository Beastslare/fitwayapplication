package com.example.fitwayapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.fitwayapp.RegisterActivity

class MainActivity : AppCompatActivity() {
    lateinit var tx_fitway:TextView
    lateinit var tx_keep:TextView
    lateinit var btn_getstarted:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tx_fitway = findViewById(R.id.txfitway)
        tx_keep = findViewById(R.id.txkeep)
        btn_getstarted = findViewById(R.id.btngetstarted)

        // Get the logged-in user's name (Replace with your actual implementation)
        val userName = "Wendy Sheila"
        val greeting = "Welcome, $userName!"


        btn_getstarted.setOnClickListener {
            // Start the workout tracking activity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
    }
}