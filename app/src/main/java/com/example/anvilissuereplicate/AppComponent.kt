package com.example.anvilissuereplicate

import com.bandlab.common.AppScope
import com.bandlab.common.Singleton
import software.amazon.lastmile.kotlin.inject.anvil.MergeComponent

@Singleton
@MergeComponent(scope = AppScope::class)
interface AppComponent
