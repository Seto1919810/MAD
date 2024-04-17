package com.example.learnactivity

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val 不可变对象 var 可变
        val loginButton: Button = findViewById(R.id.login_button)
        val welcomeTxt: TextView = findViewById(R.id.welcome_text)
        val textContent: EditText = findViewById(R.id.edit_text)
        val baiduButton: Button = findViewById(R.id.open_baidu_button)

        baiduButton.setOnClickListener {
            val intent = Intent(
                this,
                MyActionViewActivity::class.java
            )
            intent.putExtra(
                "data_pay",
                1000000.00f
            )
            startActivity(intent)
        }

        loginButton.setOnClickListener {
            // 该按钮被点击时处理的事件
            Toast.makeText(this, "你点击了按钮", Toast.LENGTH_SHORT).show()
            welcomeTxt.text = textContent.text
            // 跳转到其他Activity,显式跳转
            val intent: Intent = Intent(this,SecondActivity::class.java)
            startActivity(intent)
        }
    }
}