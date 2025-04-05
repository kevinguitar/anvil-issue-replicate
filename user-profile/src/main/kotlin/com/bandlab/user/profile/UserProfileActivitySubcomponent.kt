package com.bandlab.user.profile

// Waiting for ContributesGraphExtension
/*
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
*/