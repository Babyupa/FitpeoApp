package com.fitpeo.fitpeoapp.repository

import com.fitpeo.fitpeoapp.retrofitapicode.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {
    fun getAllPhotos() = retrofitService.getAllPhotos()
}