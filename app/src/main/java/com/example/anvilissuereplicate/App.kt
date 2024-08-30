package com.example.anvilissuereplicate

import android.app.Application

class App : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        injectApp()
    }

    private fun injectApp() {
        appComponent = DaggerAppComponent.factory().create(this)
        appComponent.inject(this)
    }
}