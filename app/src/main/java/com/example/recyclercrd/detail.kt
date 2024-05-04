package com.example.recyclercrd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class detail : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.detail)

        val bundle : Bundle? = intent.extras

        val namaDetail: TextView = findViewById(R.id.nama_detail)
        val hargaDetail: TextView = findViewById(R.id.harga_detail)

        namaDetail.text = bundle?.getString("makanan")
        hargaDetail.text = bundle?.getString("harga")
    }
}