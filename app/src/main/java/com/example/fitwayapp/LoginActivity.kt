package com.example.fitwayapp

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.example.fitwayapp.ExerciseActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    lateinit var tx_login: TextView
    lateinit var edt_email: EditText
    lateinit var edt_password: EditText
    lateinit var btn_login: Button
    lateinit var progress: ProgressDialog
    lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        tx_login = findViewById(R.id.txlogin)
        edt_email = findViewById(R.id.edtemail)
        edt_password = findViewById(R.id.edtpassword)
        btn_login = findViewById(R.id.btnlogin)
        progress = ProgressDialog(this)
        progress.setTitle("Logging In...")
        progress.setMessage("Please wait...")
        mAuth = FirebaseAuth.getInstance()

        btn_login.setOnClickListener {
            val email = edt_email.text.toString()
            val password = edt_password.text.toString()
            if (email.isEmpty()) {
                edt_email.setError("Please fill this input")
                edt_email.requestFocus()
            } else if (password.isEmpty()) {
                edt_password.setError("Please fill this input")
                edt_password.requestFocus()
            }
            progress.show()
            mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener {
                    progress.dismiss()
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, ExerciseActivity::class.java))
                        finish()
                    } else {
                        displayMessage("ERROR", it.exception!!.message.toString())
                    }
                }
            fun loginUser(email: String, password: String) {
                // TODO: Implement your login logic here

                // Example code to simulate login success
                if (email == "user@example.com" && password == "password") {
                } else {
                    // Show a toast indicating login failure
                    Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
    fun displayMessage(title: String, message: String) {
        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle(title)
        alertDialog.setMessage(message)
        alertDialog.setPositiveButton("Ok", null)
        alertDialog.create().show()


    }
}

