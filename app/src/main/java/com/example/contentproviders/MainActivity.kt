package com.example.contentproviders

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.ComponentActivity
import java.io.File
import java.io.FileOutputStream

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val uri= Uri.parse("android.resource://$packageName/drawable/kermit")
        val kermitbytes = contentResolver.openInputStream(uri)?.use {
            it.readBytes()
        }

        val file = File(filesDir,"zort.jpg")
        FileOutputStream(file).use {
            it.write(kermitbytes)
        }

        println(file.toURI())


        println(" kermit uzunluğu : ${kermitbytes?.size}")

        setContentView(R.layout.activity_main)



    }
}