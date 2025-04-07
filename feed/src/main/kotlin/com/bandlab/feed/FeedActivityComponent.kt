package com.bandlab.feed

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import com.bandlab.common.AnvilInjector
import dagger.BindsInstance
import dagger.Provides
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Includes
import kotlinx.coroutines.CoroutineScope

@ContributesTo(FeedActivity::class)
interface FeedActivityModule {
    @Provides
    fun provideLifecycle(activity: FeedActivity): Lifecycle = activity.lifecycle

    @Provides
    fun provideCoroutineScope(activity: FeedActivity): CoroutineScope = activity.lifecycleScope
}

@DependencyGraph(scope = FeedActivity::class)
interface FeedActivityComponent : AnvilInjector<FeedActivity> {

    @DependencyGraph.Factory
    interface Factory {
        fun create(
            @BindsInstance root: FeedActivity,
            @Includes serviceProvider: FeedActivity.ServiceProvider
        ): FeedActivityComponent
    }
}
