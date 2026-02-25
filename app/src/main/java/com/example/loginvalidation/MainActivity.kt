package com.example.loginvalidation

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnValidate = findViewById<Button>(R.id.btnValidate)

        btnValidate.setOnClickListener {

            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Both fields must not be empty", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches() || !email.endsWith(".edu")) {
                Toast.makeText(this, "Enter a valid college email ID", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val passwordPattern =
                Regex("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#\$%^&+=!]).{12,}$")

            if (!password.matches(passwordPattern)) {
                Toast.makeText(
                    this,
                    "Password must be minimum 12 characters,\ninclude 1 uppercase, 1 lowercase,\n1 number and 1 special symbol",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            Toast.makeText(this, "Validation Successful!", Toast.LENGTH_LONG).show()
        }
    }
}