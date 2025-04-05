package com.example.anvilissuereplicate

import android.content.Intent
import com.bandlab.common.AppScope
import com.bandlab.feed.FromFeedNavActions
import com.bandlab.user.profile.UserProfileActivity
import dev.zacsweers.metro.ContributesBinding
import javax.inject.Inject

@ContributesBinding(AppScope::class)
class FromFeedNavActionsImpl @Inject constructor(
    private val app: App
) : FromFeedNavActions {

    override fun openUserProfile(): Intent {
        return Intent(app, UserProfileActivity::class.java)
    }
}