package com.example.anvilissuereplicate

import androidx.lifecycle.Lifecycle
import javax.inject.Inject

class Logger @Inject constructor(
    private val lifecycle: Lifecycle
) {

    fun log(message: String) {
        lifecycle.currentState.toString()
        println(message)
    }
}