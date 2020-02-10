package com.example.listchecker

import android.accessibilityservice.GestureDescription
import android.app.DownloadManager
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONException
import java.io.IOException


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        webView.loadUrl("http://10.206.1.80/todo_upload/page.php")

        //listviewで表示したかった
        /*val adapter: ArrayAdapter<*> =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, data)*/

        //listView.setAdapter(adapter)

        button.setOnClickListener{
            val intent = Intent(this, toadd::class.java)
            startActivity(intent)
        }
    }
}
