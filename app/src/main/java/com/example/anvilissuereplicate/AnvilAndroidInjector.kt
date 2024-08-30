package com.example.anvilissuereplicate

import com.squareup.anvil.annotations.ContributesTo
import dagger.BindsInstance
import dagger.MembersInjector

interface AnvilAndroidInjector<T> {

    val injector: MembersInjector<T>

    fun inject(target: T) {
        injector.injectMembers(target)
    }

    interface Factory<T> {
        fun create(@BindsInstance instance: T): AnvilAndroidInjector<T>
    }
}

@ContributesTo(AppScope::class)
interface AnvilAndroidInjectorProvider {
    fun dispatchingAnvilInjector(): DispatchingAnvilInjector
}

typealias DispatchingAnvilInjector =
        Map<@JvmSuppressWildcards Class<*>, @JvmSuppressWildcards AnvilAndroidInjector.Factory<*>>
