package com.example.listchecker

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.io.IOException
import java.io.OutputStream
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL

class AsyncHttp:AsyncTask<String, Int, Boolean> {
    var urlConnection: HttpURLConnection? = null
    var flg:Boolean = false

    var title:String? = null
    var text:String? = null

    constructor(title:String){
        this.title = title
        this.text = text
    }
    override fun doInBackground(vararg params: String?): Boolean {
        var urlinput:String = "http://10.206.1.80/todo_upload/post.php"
        Log.d("TAG","aaaa")
        try{
            var url: URL = URL(urlinput)
            var urlConnection = url.openConnection() as HttpURLConnection
            urlConnection!!.setRequestMethod("POST")
            urlConnection!!.setDoOutput(true)

            //POST用パラメータ
            var postDataSample:String = "title=" + title
            //POSTパラメータ設定
            var out: OutputStream = urlConnection.getOutputStream()
            out.write(postDataSample.toByteArray())
            out.flush()
            out.close()
            Log.d("test",postDataSample)
            //レスポンスを受け取る
            urlConnection.getInputStream()

            flg = true
        }catch (e: MalformedURLException){
            e.printStackTrace()
        }catch (e: IOException){
            e.printStackTrace()
        }
        return flg
    }

}