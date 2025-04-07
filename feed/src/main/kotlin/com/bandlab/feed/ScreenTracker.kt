package com.bandlab.feed

import com.bandlab.common.Logger
import me.tatarka.inject.annotations.Inject
import software.amazon.lastmile.kotlin.inject.anvil.ContributesBinding

interface ScreenTracker {
    fun track(screen: String)
}

@Inject
@ContributesBinding(FeedActivity::class)
class ScreenTrackerImpl(
    private val logger: Logger,
    private val id: String
) : ScreenTracker {
    override fun track(screen: String) {
        logger.log("enter screen $screen, $id")
    }
}