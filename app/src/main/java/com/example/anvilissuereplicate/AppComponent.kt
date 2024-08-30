package com.example.anvilissuereplicate

import com.squareup.anvil.annotations.MergeComponent
import dagger.BindsInstance
import javax.inject.Singleton

interface AppScope

@Singleton
@MergeComponent(scope = AppScope::class)
interface AppComponent {
    fun inject(app: App)

    @MergeComponent.Factory
    interface Factory {
        fun create(@BindsInstance app: App): AppComponent
    }
}