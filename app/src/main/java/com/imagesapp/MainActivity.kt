package com.imagesapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBTN: Button = findViewById(R.id.start_btn)
        startBTN.setOnClickListener {

            val intent = Intent(this, PhotosActivity::class.java)

            val nameET: EditText = findViewById(R.id.name_et)
            val name: String = nameET.text.toString()
            intent.putExtra("name", name)

            startActivity(intent)
        }

    }
}