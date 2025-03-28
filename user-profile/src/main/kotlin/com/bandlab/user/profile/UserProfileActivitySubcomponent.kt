package com.bandlab.user.profile

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import com.bandlab.common.AnvilInjector
import com.bandlab.common.AppScope
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeSubcomponent
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import kotlinx.coroutines.CoroutineScope

@Module
@ContributesTo(UserProfileActivity::class)
object UserProfileActivityModule {

    @Provides
    fun provideLifecycle(activity: UserProfileActivity): Lifecycle = activity.lifecycle

    @Provides
    fun provideScope(activity: UserProfileActivity): CoroutineScope = activity.lifecycleScope
}

@MergeSubcomponent(scope = UserProfileActivity::class)
interface UserProfileActivitySubcomponent : AnvilInjector<UserProfileActivity> {
    @MergeSubcomponent.Factory
    interface Factory : AnvilInjector.Factory<UserProfileActivity>
}

@Module
@ContributesTo(scope = AppScope::class)
interface UserProfileActivityInjectorBinder {
    @IntoMap
    @Binds
    @ClassKey(UserProfileActivity::class)
    fun bindUserProfileActivityAnvilInjector(impl: UserProfileActivitySubcomponent.Factory):
            AnvilInjector.Factory<*>
}

@ContributesTo(scope = AppScope::class)
interface UserProfileActivityFactoryProvider {
    fun provideUserProfileActivityFactory(): UserProfileActivitySubcomponent.Factory
}
