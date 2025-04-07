package com.bandlab.feed

import me.tatarka.inject.annotations.Inject

@Inject
class FeedScreen(
    feedComponentFactory: FeedActivityComponent.Factory,
) {
    init {
        val component = feedComponentFactory.create("feed")
        component.screenTracker.track("feed")
    }
}