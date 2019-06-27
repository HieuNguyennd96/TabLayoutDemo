package com.example.dotslidingtabdemo.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.support.v4.text.HtmlCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.AppCompatTextView
import android.text.Html
import android.view.View
import com.example.dotslidingtabdemo.R
import com.example.dotslidingtabdemo.util.SharePreference
import com.example.dotslidingtabdemo.util.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_welcome.*

class WelcomeActivity : AppCompatActivity() {

    private lateinit var preference: SharePreference
    private lateinit var layouts: IntArray

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        preference = SharePreference(this)

        if (!preference.isFirstTime) {
            launchHomeScreen()
            finish()
        }

        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LAYOUT_STABLE or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

        setContentView(R.layout.activity_welcome)

        layouts = intArrayOf(
            R.layout.welcome_slide1,
            R.layout.welcome_slide2,
            R.layout.welcome_slide3,
            R.layout.welcome_slide4
        )

        addBottomDots(0)
        changeStatusBarColor()

        val pageAdapter = ViewPagerAdapter(this, layouts)

        viewPager.adapter = pageAdapter
        viewPager.addOnPageChangeListener(viewPageChangeListener)

        btnSkip.setOnClickListener {
            launchHomeScreen()
        }

        btnNext.setOnClickListener {
            val current = getItem(1)
            if (current < layouts.size) {
                viewPager.currentItem = current
            } else {
                launchHomeScreen()
            }
        }

    }

    private fun getItem(position: Int): Int = viewPager.currentItem + position

    private fun changeStatusBarColor() {

    }

    private fun addBottomDots(current: Int) {
        val dots = arrayOfNulls<AppCompatTextView>(layouts.size)

        val colorsActive = resources.getIntArray(R.array.array_dot_active)
        val colorsInactive = resources.getIntArray(R.array.array_dot_inactive)

        dotLayout.removeAllViews()

        for (i in 0 until dots.size) {
            dots[i] = AppCompatTextView(this)
            dots[i]?.let {
                if (Build.VERSION.SDK_INT >= 24) it.text = Html.fromHtml("&#8226;", HtmlCompat.FROM_HTML_MODE_LEGACY)
                else it.text = Html.fromHtml("&#8226;")
                it.textSize = 35F
                it.setTextColor(colorsInactive[current])
                dotLayout.addView(it)
            }
        }

        if (dots.isNotEmpty()) {
            dots[current]?.setTextColor(colorsActive[current])
        }
    }

    private fun launchHomeScreen() {
        preference.isFirstTime = false
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    private val viewPageChangeListener = object : ViewPager.OnPageChangeListener {
        override fun onPageScrollStateChanged(p0: Int) {}

        override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {}

        override fun onPageSelected(position: Int) {
            addBottomDots(position)
            if (position == layouts.size - 1) {
                btnNext.text = getString(R.string.start)
                btnSkip.visibility = View.GONE
            } else {
                btnNext.text = getString(R.string.next)
                btnSkip.visibility = View.VISIBLE
            }
        }
    }
}