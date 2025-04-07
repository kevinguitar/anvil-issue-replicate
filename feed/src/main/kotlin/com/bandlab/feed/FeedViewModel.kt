package com.bandlab.feed

import androidx.lifecycle.Lifecycle
import com.bandlab.common.Logger
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dev.zacsweers.metro.ContributesTo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.time.Duration.Companion.seconds

class FeedViewModel @AssistedInject constructor(
    @Assisted coroutineScope: CoroutineScope,
    logger: Logger,
    lifecycle: Lifecycle,
) {
    init {
        coroutineScope.launch {
            delay(1.seconds)
            logger.log("FeedViewModel init ${lifecycle.currentState}")
        }
    }

    @ContributesTo(FeedActivity::class)
    @AssistedFactory
    interface Factory {
        fun create(coroutineScope: CoroutineScope): FeedViewModel
    }
}