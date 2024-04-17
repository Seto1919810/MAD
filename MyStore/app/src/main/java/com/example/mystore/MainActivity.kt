package com.example.mystore

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // com.example.learnactivity.ACTION_PAY
        // 控件绑定
        val payButton: Button = findViewById(R.id.jump_to_mypay_btn)
        val payStatus: TextView = findViewById(R.id.pay_status)
        // 新的方法
        val myStartActivity = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if (it.resultCode == Activity.RESULT_OK){
                payStatus.text = "支付成功"
            }
            if (it.resultCode == Activity.RESULT_CANCELED) {

            }
        }
        payButton.setOnClickListener {
            val intent = Intent("com.example.learnactivity.ACTION_PAY")
            intent.addCategory("android.intent.category.DEFAULT")
            intent.putExtra("data_pay", 1000.00f)
            // 跳转
            myStartActivity.launch(intent)
        }
    }
}