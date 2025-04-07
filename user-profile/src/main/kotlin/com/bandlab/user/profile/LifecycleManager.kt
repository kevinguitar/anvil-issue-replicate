package com.bandlab.user.profile

import androidx.lifecycle.Lifecycle
import com.bandlab.common.Logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import me.tatarka.inject.annotations.Inject

class LifecycleManager @Inject constructor(
    lifecycle: Lifecycle,
    logger: Logger,
    scope: CoroutineScope,
) {

    init {
        lifecycle.currentStateFlow
            .onEach { logger.log("UserProfile Lifecycle: ${it.name}") }
            .launchIn(scope)
    }
}