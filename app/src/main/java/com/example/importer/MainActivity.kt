package com.example.importer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var imageView: ImageView? = null
    private var textContent: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textContent = findViewById(R.id.tv_heading)
        imageView = findViewById(R.id.iv_image)

        intent?.let {
            if(it.action == Intent.ACTION_SEND) {
                it.type?.let { intentType ->
                    if(intentType.startsWith("image")) {
                        val test = intent.getParcelableExtra<Uri>(Intent.EXTRA_STREAM)
                        imageView?.setImageURI(test)
                        textContent?.text = "Here's your selected image"
                    }
                }
            }
        }
    }
}