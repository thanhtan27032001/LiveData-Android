package com.example.livedata

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class UserAdapter(
    private val userClickListener: UserClickListener,
    private val userList: ArrayList<User>
): RecyclerView.Adapter<UserAdapter.MyViewHolder>() {

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgAvatar: ImageView
        var tvName: TextView
        var tvIntro: TextView
        var btnRemove: ImageButton

        init {
            imgAvatar = itemView.findViewById(R.id.imgAvatar)
            tvName = itemView.findViewById(R.id.tvName)
            tvIntro = itemView.findViewById(R.id.tvIntro)
            btnRemove = itemView.findViewById(R.id.btnRemove)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val user = userList[position]

        holder.imgAvatar.setImageResource(user.avatar)
        holder.tvName.text = user.name
        holder.tvIntro.text = user.intro

        holder.btnRemove.setOnClickListener {
            userClickListener.onUserRemoveButtonClick(position)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}