package com.example.anvilissuereplicate

import androidx.lifecycle.Lifecycle
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
object MainActivityModule {
    @Provides
    fun provideLifecycle(activity: MainActivity): Lifecycle = activity.lifecycle
}

@MergeSubcomponent(
    scope = MainActivity::class,
    modules = [MainActivityModule::class]
)
interface MainActivitySubcomponent : AnvilAndroidInjector<MainActivity> {
    @MergeSubcomponent.Factory
    interface Factory : AnvilAndroidInjector.Factory<MainActivity>
}

@Module // (subcomponents = [MergedMainActivitySubcomponent::class])
@ContributesTo(scope = AppScope::class)
interface MainActivityInjectorBinder {
    @IntoMap
    @Binds
    @ClassKey(MainActivity::class)
    fun bindMainActivityAnvilInjector(`impl`: MainActivitySubcomponent.Factory):
            AnvilAndroidInjector.Factory<*>
}

@ContributesTo(scope = AppScope::class)
interface MainActivityFactoryProvider {
    fun provideMainActivityFactory(): MainActivitySubcomponent.Factory
}
