package com.example.anvilissuereplicate

import android.app.Application
import com.bandlab.common.HasServiceProvider
import dev.zacsweers.metro.createGraph

class App : Application(), HasServiceProvider {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        injectApp()
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T> resolve(): T = appComponent as T

    private fun injectApp() {
        appComponent = createGraph()
        appComponent.inject(this)
    }
}