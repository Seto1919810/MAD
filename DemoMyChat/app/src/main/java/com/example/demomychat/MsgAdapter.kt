package com.example.demomychat

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MsgAdapter(val msgList: List<Msg>, val context: Context):
    RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    inner class LeftViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val friendFace: ImageView = view.findViewById(R.id.msg_friend_face)
        val content: TextView = view.findViewById(R.id.msg_left_content)
    }

    inner class RightViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val myFace: ImageView = view.findViewById(R.id.msg_my_face)
        val content: TextView = view.findViewById(R.id.msg_right_content)
    }

    override fun getItemViewType(position: Int): Int {
        val msg = msgList[position]
        return msg.type
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == Msg.TYPE_SENT) {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_right_item, parent, false)
            val holder = RightViewHolder(view)
            return holder
        } else {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.msg_left_item, parent, false)
            val holder = LeftViewHolder(view)
            return holder
        }
    }

    override fun getItemCount(): Int = msgList.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val msg = msgList[position]
        when(holder) {
            is LeftViewHolder -> {
                holder.content.text = msg.content
            }
            is RightViewHolder -> {
                holder.content.text = msg.content
            }
        }
    }
}