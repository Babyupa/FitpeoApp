package com.fitpeo.fitpeoapp.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.NonNull
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.fitpeo.fitpeoapp.MVVMApplication
import com.fitpeo.fitpeoapp.activity.TapDetailActivity
import com.fitpeo.fitpeoapp.databinding.AdapterPhotosBinding
import com.fitpeo.fitpeoapp.model.PhotosEntity
import com.fitpeo.fitpeoapp.utils.CircleTransform
import com.squareup.picasso.Picasso


class PhotosAdapter: RecyclerView.Adapter<MainViewHolder>() {
    var photos = mutableListOf<PhotosEntity>()
    var context : Context?=null

    @SuppressLint("NotifyDataSetChanged")
    fun setPhotoList(context: Context,photos: List<PhotosEntity>) {
        this.context = context
        this.photos = photos.toMutableList()
        notifyDataSetChanged()
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, viewType: Int): MainViewHolder =
        MainViewHolder(AdapterPhotosBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.apply {
            bind(photos[position])

        }
        holder.binding.listLayout.setOnClickListener {
            val intent = Intent(context,TapDetailActivity::class.java)
            intent.putExtra("title", photos[position].title)
            intent.putExtra("url", photos[position].url)
//            intent.putExtra("id", photos[position].id)
            context?.startActivity(intent)

        }

    }

    override fun getItemCount(): Int {
        return photos.size
    }

    companion object {
        abstract class MyClass {

            companion object {

                private lateinit var context: Context


            }
        }
        @JvmStatic
        @BindingAdapter("loadImage")
        fun loadImage(thumbs: ImageView, url: String) {
//            Glide.with(thumbs)
//                .load(url)
//                .circleCrop()
//                .placeholder(R.drawable.ic_launcher_foreground)
//                .error(R.drawable.ic_launcher_foreground)
//                .fallback(R.drawable.ic_launcher_foreground)
//                .into(thumbs)
            val context: Context = MVVMApplication.applicationContext()
            Picasso.with(context).load(url).transform(CircleTransform())
                .into(thumbs)

        }
    }
}
class MainViewHolder(val binding: AdapterPhotosBinding) : RecyclerView.ViewHolder(binding.root) {



    fun bind(photos: PhotosEntity) {
        binding.p= photos
    }


}
