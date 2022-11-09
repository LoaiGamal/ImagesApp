package com.imagesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_full_image.*

class FullImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full_image)

        val url = intent.getStringExtra("url")
        val picasso = Picasso.get()
        picasso.load(url)
            .placeholder(R.drawable.ic_launcher_background)
            .into(full_img)
    }
}