package com.bandlab.common

import com.squareup.anvil.annotations.ContributesTo
import dagger.BindsInstance

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

typealias DispatchingAnvilInjector =
        Map<@JvmSuppressWildcards Class<*>, @JvmSuppressWildcards AnvilInjector.Factory<*>>
