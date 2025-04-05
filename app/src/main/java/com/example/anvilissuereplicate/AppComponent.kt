package com.example.anvilissuereplicate

import com.bandlab.common.AppScope
import dagger.BindsInstance
import dev.zacsweers.metro.DependencyGraph
import javax.inject.Singleton

@Singleton
@DependencyGraph(scope = AppScope::class)
interface AppComponent {
    fun inject(app: App)

    @DependencyGraph.Factory
    interface Factory {
        fun create(@BindsInstance app: App): AppComponent
    }
}