package com.example.listchecker

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ListViewに表示するリスト項目をArrayListで準備する
        // ListViewに表示するリスト項目をArrayListで準備する
        val data = ArrayList<Any>()
        data.add("国語")
        data.add("社会")
        data.add("算数")
        data.add("理科")
        data.add("生活")
        data.add("音楽")
        data.add("図画工作")
        data.add("家庭")
        data.add("体育")

        val adapter: ArrayAdapter<*> =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, data)

        listView.setAdapter(adapter)

        button.setOnClickListener{
            val intent = Intent(this, toadd::class.java)
            startActivity(intent)
        }
    }
}
