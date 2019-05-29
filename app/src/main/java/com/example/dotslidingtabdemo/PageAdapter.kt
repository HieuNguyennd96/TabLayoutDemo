package com.example.dotslidingtabdemo

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class PageAdapter(manager: FragmentManager) : FragmentPagerAdapter(manager){

    override fun getItem(pos: Int): Fragment {
        return when(pos){
            0 -> ImageFragment.newInstance(R.drawable.image1)
            1 -> ImageFragment.newInstance(R.drawable.image2)
            else -> ImageFragment.newInstance(R.drawable.image3)
        }
    }

    override fun getCount(): Int = 3

}