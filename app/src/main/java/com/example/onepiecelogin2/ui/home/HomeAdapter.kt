package com.example.onepiecelogin2.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.onepiecelogin2.R
import com.example.onepiecelogin2.data.remote.response.IndodaxResponseItem


class HomeAdapter(private val list: List<IndodaxResponseItem>): RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.tv_title)
        val poster: ImageView = view.findViewById(R.id.iv_card)
        val released: TextView = view.findViewById(R.id.tv_released)
        val ratings: TextView = view.findViewById(R.id.tv_rating)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapter.MyViewHolder, position: Int) {
        holder.title.text = list[position].id
        holder.released.text = list[position].description
        holder.ratings.text = list[position].priceRound.toString()
        Glide.with(holder.itemView.context)
            .load("https://indodax.com/v2/logo/svg/color${list[position].urlLogo}")
            .into(holder.poster)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}