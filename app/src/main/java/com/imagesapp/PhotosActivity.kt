package com.imagesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit
import kotlinx.android.synthetic.main.activity_photos.*

class PhotosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photos)

        val name = intent.getStringExtra("name")
        name_tv.text = "Hello $name"

        supportFragmentManager.commit {
            add<ImagesFragment>(R.id.container)
        }
    }
}