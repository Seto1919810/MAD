package com.example.demomychat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    val friendList = ArrayList<Friend>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFriendList()
        val friendListView: RecyclerView = findViewById(R.id.friend_list)
        // 开始转换所有朋友列表为真正显示的实体
        val adapter = FriendAdapter(friendList, this)
        val layoutManager = LinearLayoutManager(this)
        friendListView.layoutManager = layoutManager
        friendListView.adapter = adapter
    }

    private fun initFriendList() {
        friendList.add(Friend("我叫香蕉", R.drawable.banana_pic, 1))
        friendList.add(Friend("苹果牛奶", R.drawable.apple_pic, 2))
        friendList.add(Friend("我叫香蕉", R.drawable.banana_pic, 3))
        friendList.add(Friend("苹果牛奶", R.drawable.apple_pic, 4))
        friendList.add(Friend("我叫香蕉", R.drawable.banana_pic, 5))
        friendList.add(Friend("苹果牛奶", R.drawable.apple_pic, 6))
        friendList.add(Friend("我叫香蕉", R.drawable.banana_pic, 7))
        friendList.add(Friend("苹果牛奶", R.drawable.apple_pic, 8))
        friendList.add(Friend("我叫香蕉", R.drawable.banana_pic, 9))
        friendList.add(Friend("苹果牛奶", R.drawable.apple_pic, 10))
        friendList.add(Friend("我叫香蕉", R.drawable.banana_pic, 11))
        friendList.add(Friend("苹果牛奶", R.drawable.apple_pic, 12))
        friendList.add(Friend("我叫香蕉", R.drawable.banana_pic, 13))
        friendList.add(Friend("苹果牛奶", R.drawable.apple_pic, 14))
        friendList.add(Friend("我叫香蕉", R.drawable.banana_pic, 15))
        friendList.add(Friend("苹果牛奶", R.drawable.apple_pic, 16))
        friendList.add(Friend("我叫香蕉", R.drawable.banana_pic, 17))
        friendList.add(Friend("苹果牛奶", R.drawable.apple_pic, 18))
        friendList.add(Friend("我叫香蕉", R.drawable.banana_pic, 19))
        friendList.add(Friend("苹果牛奶", R.drawable.apple_pic, 20))
    }
}