package com.example.listchecker


import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.toadd.*

class toadd:AppCompatActivity(){
    lateinit var addtitle:String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.toadd)



        confirm.setOnClickListener{
            if(input.text != null) {
                addtitle = input.text.toString()
            }
            toaddevent()
        }
    }

    fun toaddevent(){
        Log.d("TAG","ボタンが押されました")
        var post: AsyncHttp = AsyncHttp(addtitle)
        post.execute()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
