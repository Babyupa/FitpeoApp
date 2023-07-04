package com.fitpeo.fitpeoapp.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fitpeo.fitpeoapp.R
import com.fitpeo.fitpeoapp.adapter.PhotosAdapter
import com.fitpeo.fitpeoapp.databinding.ActivityMainBinding
import com.fitpeo.fitpeoapp.repository.MainRepository
import com.fitpeo.fitpeoapp.retrofitapicode.MainViewModel
import com.fitpeo.fitpeoapp.retrofitapicode.RetrofitService
import com.fitpeo.fitpeoapp.viewmodel.ViewModelFactory

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel
    private val retrofitService = RetrofitService.getInstance()
    val adapter = PhotosAdapter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.toolbar.setBackgroundColor(Color.parseColor("#457b9d"))
        setSupportActionBar(binding.toolbar)

        viewModel = ViewModelProvider(this, ViewModelFactory(MainRepository(retrofitService))).get(
            MainViewModel::class.java)
        binding.recyclerview.adapter = adapter
        viewModel.movieList.observe(this, Observer {
            Log.d(TAG, "onCreate: $it")
            adapter.setPhotoList(this,it)
        })
        viewModel.errorMessage.observe(this, Observer {
        })
        viewModel.getAllPhotos()
    }
}