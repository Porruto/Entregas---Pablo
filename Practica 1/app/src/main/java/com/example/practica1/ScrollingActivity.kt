package com.example.practica1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import com.example.practica1.databinding.ActivityScrollingBinding
import com.bumptech.glide.Glide

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding
    private lateinit var img1: ImageView
    private lateinit var img2: ImageView
    private lateinit var img3: ImageView
    private lateinit var img4: ImageView
    private lateinit var btn1: Button
    private lateinit var btn2: Button
    private lateinit var btn3: Button
    private lateinit var btn4: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScrollingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val intent = Intent(Intent.ACTION_VIEW)
        btn1 = findViewById(R.id.button1)
        btn2 = findViewById(R.id.button2)
        btn3 = findViewById(R.id.button3)
        btn4 = findViewById(R.id.button4)


        btn1.setOnClickListener{
            intent.data = Uri.parse("https://es.wikipedia.org/wiki/Fernando_Alonso")
            startActivity(intent)
        }
        btn2.setOnClickListener{
            intent.data = Uri.parse("https://es.wikipedia.org/wiki/Pedro_S%C3%A1nchez")
            startActivity(intent)
        }
        btn3.setOnClickListener{
            intent.data = Uri.parse("https://es.wikipedia.org/wiki/Lamine_Yamal")
            startActivity(intent)
        }
        btn4.setOnClickListener{
            intent.data = Uri.parse("https://es.wikipedia.org/wiki/Elon_Musk")
            startActivity(intent)
        }

        img1 = findViewById(R.id.imageView1)
        Glide.with(this)
            .load("https://imagenes.20minutos.es/files/image_990_556/uploads/imagenes/2024/09/30/fernando-alonso-durante-el-gp-de-azerbaiyan-2024.jpeg")
            .into(img1)


        img2 = findViewById(R.id.imageView2)
        Glide.with(this)
            .load("https://upload.wikimedia.org/wikipedia/commons/thumb/f/f0/Pedro_S%C3%A1nchez_in_2023.jpg/220px-Pedro_S%C3%A1nchez_in_2023.jpg")
            .into(img2)


        img3= findViewById(R.id.imageView3)
        Glide.with(this)
            .load("https://www.fcbarcelona.com/photo-resources/2024/09/07/8c4f80a6-48cf-492d-b964-7a68808c7029/EA019746.jpg?width=1200&height=750")
            .into(img3)


        img4 = findViewById(R.id.imageView4)
        Glide.with(this)
            .load("https://cdn.urbantecno.com/urbantecno/s/2023-01-05-11-27-elon-musk.png")
            .into(img4)

    }
}