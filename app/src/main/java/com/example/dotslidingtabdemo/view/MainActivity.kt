package com.example.dotslidingtabdemo.view

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.dotslidingtabdemo.R
import com.example.dotslidingtabdemo.util.SharePreference
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var preference: SharePreference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        preference = SharePreference(this)
        preference.isFirstTime = true

        txtShowSlider.setOnClickListener {
            startActivity(Intent(this,WelcomeActivity::class.java))
            finish()
        }
    }
}