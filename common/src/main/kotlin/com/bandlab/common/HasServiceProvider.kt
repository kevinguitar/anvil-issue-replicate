package com.bandlab.common

import android.app.Activity
import android.content.Context

interface HasServiceProvider {
    fun <T> resolve(): T
}

fun <T> Context.resolveServiceProvider(): T {
    val app = applicationContext
    return when {
        this is Activity && this is HasServiceProvider -> this.resolve()
        app is HasServiceProvider -> app.resolve()
        else -> error("Application doesn't implement HasServiceProvider interface")
    }
}
