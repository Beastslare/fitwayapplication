package com.example.fitwayapp

import android.app.AlertDialog
import android.app.ProgressDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.fitwayapp.LoginActivity
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {
    lateinit var tx_register: TextView
    lateinit var edt_name: EditText
    lateinit var edt_password: EditText
    lateinit var edt_email: EditText
    lateinit var edt_phone: EditText
    lateinit var btn_register: Button
    lateinit var progress: ProgressDialog
    lateinit var mAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        tx_register = findViewById(R.id.txregister)
        edt_name = findViewById(R.id.edtname)
        edt_password = findViewById(R.id.edtpassword)
        edt_email = findViewById(R.id.edtemail)
        edt_phone = findViewById(R.id.edtphone)
        btn_register = findViewById(R.id.btnregister)
        progress = ProgressDialog(this)
        mAuth = FirebaseAuth.getInstance()


        btn_register.setOnClickListener {
            val username = edt_name.text.toString()
            val email = edt_email.text.toString()
            val password = edt_password.text.toString()
            val phonenumber = edt_phone.text.toString()
            if (email.isEmpty()) {
                edt_email.setError("Please fill this input")
                edt_email.requestFocus()
            } else if (password.isEmpty()) {
                edt_password.setError("Please fill this input")
                edt_password.requestFocus()
            } else if (password.length < 6) {
                edt_password.setError("Password too short")
                edt_password.requestFocus()
            } else if (phonenumber.isEmpty()) {
                edt_phone.setError("Please input your ID Number!")
                edt_phone.requestFocus()
            } else if (username.isEmpty()) {
                edt_name.setError("Please input your ID Number!")
                edt_name.requestFocus()
            } else {
                progress.setTitle("Registering")
                progress.setMessage("Please wait...")
                progress.show()
                mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        progress.dismiss()
                        if (it.isSuccessful) {
                            Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT)
                                .show()
                            startActivity(Intent(this, LoginActivity::class.java))
                            finish()
                        } else {
                            displayMessage("ERROR", it.exception!!.message.toString())
                        }

                    }
            }
            btn_register.setOnClickListener {
                startActivity(Intent(this, LoginActivity::class.java))
                progress = ProgressDialog(this)
                progress.setTitle("Loading")
                progress.setMessage("Please wait...")
                progress.show()
            }

            fun registerUser(
                username: String,
                email: String,
                password: String,
                phonenumber: String
            ) {
                // TODO: Implement your registration logic here

                // Example code to start the main activity after registration
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()


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