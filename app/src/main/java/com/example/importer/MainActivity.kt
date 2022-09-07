package com.example.importer

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var imageView: ImageView? = null;
    private var textContent: TextView? = null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        window.decorView = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;

        textContent = findViewById(R.id.tv_heading)
        imageView = findViewById(R.id.iv_image);

        intent?.let {
//            val intentAction = it.action;
//            val intentType = it.type;

            if(it.action == Intent.ACTION_SEND) {
                it.type?.let { intentType ->
                    if(intentType.startsWith("image")) {
//                        this.imageHandler(intent);
                        val test = intent.getParcelableExtra<Uri>(Intent.EXTRA_STREAM);
                        imageView?.setImageURI(test);
                        textContent?.setText("Here's your selected image");
                        Log.d("INTENT OBJECT", test?.path.toString());
                    }
                }
            }

//            Log.d("INTENT ACTION", intentAction.toString());
//            Log.d("INTENT TYPE", intentType.toString());
        }
    }

//    private fun imageHandler(intent: Intent) {
//        val image = intent.getParcelableExtra<Image>()
//
//    }
}