package com.bandlab.user.profile

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import com.bandlab.common.ActivityScope
import com.bandlab.common.AnvilInjector
import com.bandlab.common.AppScope
import kotlinx.coroutines.CoroutineScope
import me.tatarka.inject.annotations.IntoMap
import me.tatarka.inject.annotations.Provides
import software.amazon.lastmile.kotlin.inject.anvil.ContributesSubcomponent
import software.amazon.lastmile.kotlin.inject.anvil.ContributesTo
import kotlin.reflect.KClass

@ContributesTo(UserProfileActivity::class)
interface UserProfileActivityModule {

    @Provides
    fun provideLifecycle(activity: UserProfileActivity): Lifecycle = activity.lifecycle

    @Provides
    fun provideScope(activity: UserProfileActivity): CoroutineScope = activity.lifecycleScope
}

@ActivityScope
@ContributesSubcomponent(scope = UserProfileActivity::class)
interface UserProfileActivitySubcomponent { //: AnvilInjector<UserProfileActivity> {
    @ContributesSubcomponent.Factory(AppScope::class)
    interface Factory { //: AnvilInjector.Factory<UserProfileActivity> {
        fun createUserProfileActivitySubcomponent(): UserProfileActivitySubcomponent
    }
}

//@ContributesTo(scope = AppScope::class)
//interface UserProfileActivityInjectorBinder {
//    @IntoMap
//    @Provides
//    fun provideUserProfileActivityAnvilInjector(
//        impl: UserProfileActivitySubcomponent.Factory
//    ): Pair<KClass<*>, AnvilInjector.Factory<*>> {
//        return UserProfileActivity::class to impl
//    }
//}

@ContributesTo(scope = AppScope::class)
interface UserProfileActivityFactoryProvider {
    fun provideUserProfileActivityFactory(): UserProfileActivitySubcomponent.Factory
}
