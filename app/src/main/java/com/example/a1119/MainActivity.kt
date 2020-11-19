package com.example.a1119

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val list = arrayOf("message1","message2","message3","message4","message5")
        button.setOnClickListener {
            AlertDialog.Builder(this)
                    .setTitle("請選擇功能")
                    .setMessage("請根據按鈕選擇物件")
                    .setNeutralButton("取消") {
                        dialog, which -> Toast.makeText(this, "取消", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("自訂義Toast") {
                        dialog, which -> Toast.makeText(this, "自定義Toast", Toast.LENGTH_LONG).show()
                        val toast = Toast(this)
                        toast.setGravity(Gravity.TOP,0,50)
                        toast.duration = Toast.LENGTH_SHORT
                        toast.view = layoutInflater.inflate(R.layout.custom_toast,null)
                        toast.show()
                    }
                    .setPositiveButton("顯示list") {
                        dialog, which -> Toast.makeText(this, "顯示list",Toast.LENGTH_SHORT).show()
                        AlertDialog.Builder(this)
                                .setTitle("使用list呈現")
                                .setItems(list) {
                                    dialogInterface, i ->
                                    Toast.makeText(this, "你選擇的是"+list[i],Toast.LENGTH_SHORT).show()
                                }.show()
                    }.show()
        }
    }
}