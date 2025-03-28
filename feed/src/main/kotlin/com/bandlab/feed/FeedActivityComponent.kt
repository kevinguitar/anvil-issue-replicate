package com.bandlab.feed

import androidx.lifecycle.Lifecycle
import com.bandlab.common.AnvilAndroidInjectorProvider
import com.bandlab.common.AnvilInjector
import com.bandlab.common.AppScope
import com.squareup.anvil.annotations.ContributesTo
import com.squareup.anvil.annotations.MergeComponent
import dagger.Binds
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap

@Module
@ContributesTo(FeedActivity::class)
object FeedActivityModule {
    @Provides
    fun provideLifecycle(activity: FeedActivity): Lifecycle = activity.lifecycle
}

@MergeComponent(
    scope = FeedActivity::class,
    dependencies = [FeedActivity.ServiceProvider::class]
)
interface FeedActivityComponent : AnvilInjector<FeedActivity> {

    @MergeComponent.Factory
    interface Factory {
        fun create(
            @BindsInstance root: FeedActivity,
            serviceProvider: FeedActivity.ServiceProvider
        ): FeedActivityComponent
    }
}
