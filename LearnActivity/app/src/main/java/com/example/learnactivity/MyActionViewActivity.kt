package com.example.learnactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class MyActionViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_action_view)
        // 所有控件绑定
        val payValue: TextView = findViewById(R.id.pay_value)
        val payButton: Button = findViewById(R.id.btn_pay)
        // 支付金额获取,这里的name需要事先约定好
        val dataValue = intent.getFloatExtra("data_pay", 0.0f)
        payValue.text = "$dataValue 元"
        // 点击开始支付操作
        payButton.setOnClickListener {
            Log.d("Page Pay:", "身份认证完成!")
            // 生成返回包裹
            val returnIntent = Intent()
            // 设置状态标签（成功与否）
            setResult(RESULT_OK, returnIntent)
            // 关闭当前Activity
            finish()
        }
    }
}