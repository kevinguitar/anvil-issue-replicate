package com.bandlab.common

import software.amazon.lastmile.kotlin.inject.anvil.ContributesTo
import kotlin.reflect.KClass

interface AnvilInjector<T : Any> {

    fun inject(target: T)

    interface Factory<T : Any> {
        fun create(instance: T): AnvilInjector<T>
    }
}

//@ContributesTo(AppScope::class)
interface AnvilAndroidInjectorProvider {
    fun dispatchingAnvilInjector(): DispatchingAnvilInjector
}

typealias DispatchingAnvilInjector =
        Map<@JvmSuppressWildcards KClass<*>, @JvmSuppressWildcards AnvilInjector.Factory<*>>
