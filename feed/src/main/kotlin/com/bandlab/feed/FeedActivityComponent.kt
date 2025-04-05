package com.bandlab.feed

import androidx.lifecycle.Lifecycle
import com.bandlab.common.AnvilInjector
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Includes

@Module
@ContributesTo(FeedActivity::class)
interface FeedActivityModule {
    @Provides
    fun provideLifecycle(activity: FeedActivity): Lifecycle = activity.lifecycle
}

@DependencyGraph(
    scope = FeedActivity::class,
//    dependencies = [FeedActivity.ServiceProvider::class]
)
interface FeedActivityComponent : AnvilInjector<FeedActivity> {

    @DependencyGraph.Factory
    interface Factory {
        fun create(
            @BindsInstance root: FeedActivity,
            @Includes serviceProvider: FeedActivity.ServiceProvider
//            serviceProvider: FeedActivity.ServiceProvider
        ): FeedActivityComponent
    }
}
