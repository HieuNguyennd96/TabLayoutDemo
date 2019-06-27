package com.example.dotslidingtabdemo.util

import android.content.Context
import android.support.v4.view.PagerAdapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ViewPagerAdapter(val context: Context, val layouts: IntArray) : PagerAdapter() {

    private lateinit var layoutInflater: LayoutInflater

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val view = layoutInflater.inflate(layouts[position], container, false)
        container.addView(view)

        return view
    }

    override fun isViewFromObject(view: View, any: Any): Boolean = view == any

    override fun getCount(): Int = layouts.size

    override fun destroyItem(container: ViewGroup, position: Int, any: Any) {
        val view = any as View
        container.removeViewInLayout(view)
    }
}