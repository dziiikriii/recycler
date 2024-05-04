package com.example.recyclercrd

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class adapter (private val context: Context, private val data:ArrayList<container>): RecyclerView.Adapter<adapter.MakananViewHolder>() {

    override fun onBindViewHolder(holder: MakananViewHolder, position: Int) {
        val currentItem = data[position]
        holder.tvMakanan.text = currentItem.makanan
        holder.tvHarga.text = currentItem.harga
        holder.itemView.setOnClickListener() {
            val intent = Intent(context, detail::class.java)
            intent.putExtra("makanan", currentItem.makanan)
            intent.putExtra("harga", currentItem.harga)
            context.startActivity(intent)
        }

        holder.delete.setOnClickListener() {
            val pos = holder.adapterPosition
            if (pos != RecyclerView.NO_POSITION) {
                data.removeAt(pos)
                notifyItemRemoved(pos)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MakananViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.item ,parent, false)
        return MakananViewHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    class MakananViewHolder(ItemView: View) :
        RecyclerView.ViewHolder(ItemView) {
        var tvMakanan = ItemView.findViewById<TextView>(R.id.tvMakanan)
        var tvHarga = ItemView.findViewById<TextView>(R.id.tvHarga)
        val delete = ItemView.findViewById<ImageButton>(R.id.delete_btn)

    }


}