package com.fitpeo.fitpeoapp.retrofitapicode

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fitpeo.fitpeoapp.model.PhotosEntity
import com.fitpeo.fitpeoapp.repository.MainRepository
import retrofit2.Call
import retrofit2.Response

class MainViewModel  constructor(private val repository: MainRepository)  : ViewModel() {

    val movieList = MutableLiveData<List<PhotosEntity>>()
    val errorMessage = MutableLiveData<String>()

    fun getAllPhotos() {
        val response = repository.getAllPhotos()
        response.enqueue(object : retrofit2.Callback<List<PhotosEntity>> {
            override fun onResponse(call: Call<List<PhotosEntity>>, response: Response<List<PhotosEntity>>) {
                movieList.postValue(response.body())
            }
            override  fun onFailure(call: Call<List<PhotosEntity>>, t: Throwable) {
                errorMessage.postValue(t.message)
            }
        })
    }

}