package com.bandlab.common

import dagger.BindsInstance
import dagger.Module
import dagger.multibindings.Multibinds
import dev.zacsweers.metro.ContributesTo

interface AnvilInjector<T: Any> {

    fun inject(target: T)

    interface Factory<T : Any> {
        fun create(@BindsInstance instance: T): AnvilInjector<T>
    }
}

@ContributesTo(AppScope::class)
interface AnvilAndroidInjectorProvider {
    fun dispatchingAnvilInjector(): DispatchingAnvilInjector
}

@Module
@ContributesTo(AppScope::class)
interface AnvilAndroidInjectorModule {
    @Multibinds
    fun dispatchingAnvilInjector(): DispatchingAnvilInjector
}

typealias DispatchingAnvilInjector =
        Map<@JvmSuppressWildcards Class<*>, @JvmSuppressWildcards AnvilInjector.Factory<*>>
