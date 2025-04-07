package com.bandlab.feed

import androidx.lifecycle.Lifecycle
import com.bandlab.common.ActivityScope
import com.bandlab.common.AppScope
import me.tatarka.inject.annotations.Provides
import software.amazon.lastmile.kotlin.inject.anvil.ContributesSubcomponent
import software.amazon.lastmile.kotlin.inject.anvil.ContributesTo

@ContributesTo(FeedActivity::class)
interface FeedActivityModule {
    @Provides
    fun provideLifecycle(activity: FeedActivity): Lifecycle = activity.lifecycle
}

@ActivityScope
@ContributesSubcomponent(scope = FeedActivity::class)
interface FeedActivityComponent {
//    fun inject(screen: FeedScreen)
    val screenTracker: ScreenTracker

    @ContributesSubcomponent.Factory(AppScope::class)
    interface Factory {
        fun create(id: String): FeedActivityComponent
    }
}