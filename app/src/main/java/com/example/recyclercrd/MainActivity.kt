package com.example.recyclercrd

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.animation.AnimationUtils
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.interpolator.view.animation.FastOutSlowInInterpolator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclercrd.VIewExt


class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rv : RecyclerView = findViewById(R.id.recyclerView)
        val add : Button = findViewById(R.id.add)
        val black_linear : ImageView = findViewById(R.id.black_linear)
        val bg_linear : ImageView = findViewById(R.id.bg_linear)
        val linear : LinearLayout = findViewById(R.id.linear)
        val nama_add : EditText = findViewById(R.id.nama_add)
        val harga_add : EditText = findViewById(R.id.harga_add)
        val selesai_add : Button = findViewById(R.id.selesai_add)

        val data: ArrayList<container> = ArrayList()
        data.addAll(getData())
        val adapter = adapter(this, data)
        rv.adapter = adapter
        rv.layoutManager = LinearLayoutManager(this)

        add.setOnClickListener() {
            black_linear.visibility = View.VISIBLE
            bg_linear.visibility = View.VISIBLE
            linear.visibility = View.VISIBLE

            black_linear.transparentIn(1000, 0)
            linear.slideDown(1000, 0)
            bg_linear.slideDown(1000, 0)


            selesai_add.setOnClickListener() {
                val makanan = nama_add.text.toString()
                val harga = harga_add.text.toString()

                if(makanan.isNotEmpty() && harga.isNotEmpty()) {
                    val menu = container()
                    menu.makanan = makanan
                    menu.harga = harga
                    data.add(menu)
                    adapter.notifyDataSetChanged()

                    nama_add.setText("")
                    harga_add.setText("")

                    black_linear.visibility = View.GONE
                    bg_linear.visibility = View.GONE
                    linear.visibility = View.GONE

                    black_linear.transparentOut(1000, 0)
                    linear.slideUp(1000, 0)
                    bg_linear.slideUp(1000, 0)

                } else {
                    Toast.makeText(this@MainActivity, "Makanan dan Harga harus diisi", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }

    fun getData():ArrayList<container> {
        val data = ArrayList<container>()
        val nama = resources.getStringArray(R.array.makanan)
        val harga = resources.getStringArray(R.array.harga)
        for (i in harga.indices){
            val food = container()
            food.makanan = nama[i]
            food.harga= harga[i]
            data.add(food)
        }
        return data
    }

    fun View.slideDown(animTime: Long, startOffset: Long) {
        val slideDown = AnimationUtils.loadAnimation(context, R.anim.slide_down).apply {
            duration = animTime
            interpolator = FastOutSlowInInterpolator()
            this.startOffset = startOffset
        }
        startAnimation(slideDown)
    }

    fun View.slideUp(animTime: Long, startOffset: Long) {
        val slideUp = AnimationUtils.loadAnimation(context, R.anim.slide_up).apply {
            duration = animTime
            interpolator = FastOutSlowInInterpolator()
            this.startOffset = startOffset
        }
        startAnimation(slideUp)
    }

    fun View.transparentIn(animTime: Long, startOffset: Long) {
        val transparentIn = AnimationUtils.loadAnimation(context, R.anim.transparent_in).apply {
            duration = animTime
            interpolator = FastOutSlowInInterpolator()
            this.startOffset = startOffset
        }
        startAnimation(transparentIn)
    }

    fun View.transparentOut(animTime: Long, startOffset: Long) {
        val transparentOut = AnimationUtils.loadAnimation(context, R.anim.transparent_out).apply {
            duration = animTime
            interpolator = FastOutSlowInInterpolator()
            this.startOffset = startOffset
        }
        startAnimation(transparentOut)
    }

}