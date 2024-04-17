package com.example.demomychat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MsgActivity : AppCompatActivity() {

    val msgList = ArrayList<Msg>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_msg)
        // 找控件
        val friendInfo: TextView = findViewById(R.id.friend_info)
        val inputText: EditText = findViewById(R.id.msg_input_text)
        val sendButton: Button = findViewById(R.id.msg_send_btn)
        // 获取传递过来的数据
        val name = intent.getStringExtra("name")
        val id = intent.getIntExtra("id", 0)
        // 显示朋友信息
        friendInfo.text = "${id}: $name"


        // RecyclerView的数据填充
        // val msgList = ArrayList<Msg>()
        val recyclerView: RecyclerView = findViewById(R.id.msg_recycler_view)
        initMsgList()
        val layoutManager = LinearLayoutManager(this)
        val adapter = MsgAdapter(msgList, this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        sendButton.setOnClickListener {
            val msg = Msg(inputText.text.toString(), Msg.TYPE_SENT, 2)
            msgList.add(msg)
            adapter.notifyItemInserted(msgList.size - 1)
            recyclerView.scrollToPosition(msgList.size -1)
            inputText.setText("")

        }
    }

    private fun initMsgList() {
        msgList.add(Msg("你好！", Msg.TYPE_RECEIVED, 1))
        msgList.add(Msg("你好！！！！", Msg.TYPE_SENT, 2))
        msgList.add(Msg("干啥呢", Msg.TYPE_RECEIVED,1))
    }
}