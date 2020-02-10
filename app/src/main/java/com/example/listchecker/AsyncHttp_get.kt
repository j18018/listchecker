package com.example.listchecker


import android.os.AsyncTask
import android.util.Log
import android.widget.TextView
import okhttp3.CacheControl
import okhttp3.OkHttpClient
import okhttp3.Request
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.MalformedURLException
import java.net.URL


class AsyncHttp_get: AsyncTask<String, String, String>() {
    override fun doInBackground(vararg params: String?): String? {
        var connection: HttpURLConnection? = null
        var reader: BufferedReader? = null
        var buffer: StringBuffer
        var urlinput:String = "http://10.206.1.80/todo_upload/get.php"
        try {
            val url = URL(urlinput)
            connection = url.openConnection() as HttpURLConnection

            //Apiから返ってきたjsonの処理
            val stream = connection.getInputStream()
            reader = BufferedReader(InputStreamReader(stream, "UTF-8"))
            buffer = StringBuffer()

            var line: String?
            while (true) {
                line = reader.readLine()
                if (line == null) {
                    break
                }
                buffer.append(line)
                Log.d("CHECK", buffer.toString())
            }

            //jsonから結果を取り出す
            val jsonText = buffer.toString()
            val jsonObject = JSONObject(jsonText)
            val result = jsonObject.getString("title")
            Log.d("TAG",result)
            return result


            //例外が起こった時の処理
        } catch (e: MalformedURLException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } catch (e: JSONException) {
            e.printStackTrace()
        } finally {
            connection?.disconnect()
            try {
                reader?.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }

        //例外が起こった時の返り値
        return null
    }

    /*override fun doInBackground(vararg params: String?): JSONArray? {
        val request: Request = CacheControl.Builder()
            .URL("接続先URL")
            .get()
            .build()
        val client = OkHttpClient()
        try {
            val response = client.newCall(request).execute()
            val jsonData = response.body()!!.string()
            try {
                val Jarray = JSONArray(jsonData)
                var tempStr: String
                for (i in 0 until Jarray.length()) {
                    tempStr = Jobject.getJSONObject(i).getString("title")
                }
                return Jarray
            } catch (e: JSONException) {
                Log.e("MYAPP", "unexpected JSON exception", e)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
        return Jarray
    }*/


    override fun onPostExecute(rtn: String?) {
        super.onPostExecute(rtn)
        if (rtn == null) rtn

    }
}