package com.example.demomychat

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class FriendAdapter(val friendList: List<Friend>, val context: Context):
    RecyclerView.Adapter<FriendAdapter.ViewHolder>() {
    class ViewHolder(view: View):
        RecyclerView.ViewHolder(view){
            val friendFace: ImageView = view.findViewById(R.id.friend_face_id)
            val friendName: TextView = view.findViewById(R.id.friend_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.friend_item, parent,false)
        val holder = ViewHolder(view)
        // 1. val intent = Intent(context, target activity::class.java)
        // 2. val intent = Intent("隐式跳转")
        holder.itemView.setOnClickListener{
            val position = holder.adapterPosition
            val friend = friendList[position]
            Toast.makeText(
                parent.context,
                "${position}:${friend.name} ${friend.id}",
                Toast.LENGTH_SHORT
            ).show()
            // 跳转到MsgActivity
            val intent = Intent(context, MsgActivity::class.java)
            intent.putExtra("name", friend.name)
            intent.putExtra("id", friend.id)
            context.startActivity(intent)
        }
        return holder
    }

    override fun getItemCount(): Int {
        return friendList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val friend = friendList[position]
        holder.friendName.text = friend.name
        holder.friendFace.setImageResource(friend.face)
    }
}