package com.example.livedata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(
    private val userList: ArrayList<User>
): RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar: ImageView
        var tvName: TextView
        var tvIntro: TextView

        init {
            imgAvatar = itemView.findViewById(R.id.imgAvatar)
            tvName = itemView.findViewById(R.id.tvName)
            tvIntro = itemView.findViewById(R.id.tvIntro)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: UserAdapter.MyViewHolder, position: Int) {
        val user = userList[position]

        holder.imgAvatar.setImageResource(user.avatar)
        holder.tvName.text = user.name
        holder.tvIntro.text = user.intro
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}