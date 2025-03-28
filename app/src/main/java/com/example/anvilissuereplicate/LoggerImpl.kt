package com.example.anvilissuereplicate

import com.bandlab.common.AppScope
import com.bandlab.common.Logger
import com.squareup.anvil.annotations.ContributesBinding
import javax.inject.Inject

@ContributesBinding(AppScope::class)
class LoggerImpl @Inject constructor() : Logger {
    override fun log(message: String) {
        println(message)
    }
}