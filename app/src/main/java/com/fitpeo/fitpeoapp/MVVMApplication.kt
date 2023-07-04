package com.fitpeo.fitpeoapp

import android.app.Application
import android.content.Context
import androidx.lifecycle.ViewModelProvider.NewInstanceFactory.Companion.instance


class MVVMApplication : Application() {

//    lateinit var applicationComponent: ApplicationComponent

    init {
        instance = this
    }

    companion object{
        private var instance :MVVMApplication?=null

        fun applicationContext():Context{
            return instance!!.applicationContext
        }
    }
    override fun onCreate() {
        super.onCreate()
        injectDependencies()

    }

    private fun injectDependencies() {
//        applicationComponent = DaggerApplicationComponent
//            .builder()
//            .applicationModule(ApplicationModule(this))
//            .build()
//        applicationComponent.inject(this)
    }

}