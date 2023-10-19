package com.example.onepieceapps.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.onepieceapps.data.entity.User
import com.example.onepieceapps.R

class UserAdaptor(var list: List<User>) : RecyclerView.Adapter<UserAdaptor.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var fullName: TextView
        var email: TextView
        var password: TextView

        init{
            fullName = view.findViewById(R.id.et_Name)
            email = view.findViewById(R.id.et_Email)
            password = view.findViewById(R.id.et_Password)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_user, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fullName.text = list[position].fullName
        holder.email.text = list[position].email
        holder.password.text = list[position].password
    }

    override fun getItemCount(): Int {
        return list.size
    }


}