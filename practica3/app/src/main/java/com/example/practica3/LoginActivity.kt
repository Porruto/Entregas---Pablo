package com.example.practica3

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val login = findViewById<TextInputEditText>(R.id.loginText)
        val password = findViewById<TextInputEditText>(R.id.paswordText)
        val boton = findViewById<Button>(R.id.bLogin)
        boton.setOnClickListener{
            val user = login.text.toString()
            val pass = password.text.toString()
            if (user != "" && pass != "") {
                putInfo(user, pass)
                val intent = Intent(this, NoticiaActivity::class.java)
                startActivity(intent)
            }else {
                Toast.makeText(
                    this, "Introduce los datos del login",
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun putInfo(user:String, pass:String) {
        val sharedPref = getSharedPreferences("user_info", Context.MODE_PRIVATE)
        with (sharedPref.edit()){
            putString("user", user)
            putString("pass", pass)
            apply()
        }
    }
}