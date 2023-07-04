package com.fitpeo.fitpeoapp.activity

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.fitpeo.fitpeoapp.R
import com.fitpeo.fitpeoapp.databinding.ActivityTapDetailBinding
import com.squareup.picasso.Picasso

class TapDetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTapDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tap_detail)
        binding = ActivityTapDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.setBackgroundColor(Color.parseColor("#457b9d"))
        setSupportActionBar(binding.toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.title = "Tap Detail"

        var title =     intent.getStringExtra("title")
//        var id =     intent.getStringExtra("id")
        var url =     intent.getStringExtra("url")
//        Log.d("TAG", "$titile")
        Picasso.with(this).load(url).into(binding.imageViewBanner)
        binding.textViewDescription.setText(title)

    }
}