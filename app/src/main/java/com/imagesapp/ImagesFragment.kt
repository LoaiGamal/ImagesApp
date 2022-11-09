package com.imagesapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView


class ImagesFragment : Fragment() {

    lateinit var adapter: ImagesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_images, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvImages = view.findViewById<View>(R.id.rvImages) as RecyclerView
        adapter = ImagesAdapter(generateImageList()) {showFullImage(it)}
        rvImages.adapter = adapter
        rvImages.layoutManager = GridLayoutManager(requireContext(), 3)
    }

    private fun generateImageList(): List<Image>{
        val list = ArrayList<Image>()
        for (i in 100 .. 200){
            list.add(Image("https://picsum.photos/id/${i}/200/300", i))
        }
        return list
    }

    private fun showFullImage(url: String){
        val intent = Intent(requireContext(), FullImageActivity::class.java)
        intent.putExtra("url", url)
        startActivity(intent)
    }
}