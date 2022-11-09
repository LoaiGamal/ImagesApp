package com.imagesapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class ImagesAdapter (private val images: List<Image>, val click: (url: String) -> Unit):
    RecyclerView.Adapter<ImagesAdapter.ViewHolder>(){

    inner class ViewHolder (imageView: View): RecyclerView.ViewHolder(imageView){
        val imageView: ImageView = itemView.findViewById(R.id.imageView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.image, parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val image = images[position]
        val picasso = Picasso.get()
        picasso.load(image.imageURL)
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.imageView)

        holder.itemView.setOnClickListener{click(image.imageURL)}
    }

    override fun getItemCount(): Int {
        return images.size
    }
}