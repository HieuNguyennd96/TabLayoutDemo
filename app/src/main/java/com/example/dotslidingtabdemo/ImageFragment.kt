package com.example.dotslidingtabdemo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_image.*

class ImageFragment : Fragment() {
    // TODO: Rename and change types of parameters

    companion object {
        const val IMAGE = "IMAGE"

        fun newInstance(image: Int): Fragment {
            val fragment = ImageFragment()
            val args = Bundle()
            args.putInt(IMAGE, image)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val image = arguments?.getInt(IMAGE)
        if (image != null) {
            image_view.setImageResource(image)
        } else {
            image_view.setImageResource(R.drawable.image1)
        }

    }
}
