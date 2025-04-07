package com.example.anvilissuereplicate

import com.bandlab.common.AppScope
import com.bandlab.common.Logger
import me.tatarka.inject.annotations.Inject
import software.amazon.lastmile.kotlin.inject.anvil.ContributesBinding

@ContributesBinding(AppScope::class)
class LoggerImpl @Inject constructor() : Logger {
    override fun log(message: String) {
        println(message)
    }
}