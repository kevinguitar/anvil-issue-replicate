package com.bandlab.feed

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import com.bandlab.common.AnvilInjection
import com.bandlab.common.AppScope
import com.bandlab.common.HasServiceProvider
import com.bandlab.common.Logger
import com.bandlab.common.resolveServiceProvider
import dev.zacsweers.metro.ContributesTo
import dev.zacsweers.metro.createGraphFactory
import javax.inject.Inject

class FeedActivity : ComponentActivity(), HasServiceProvider {

    @Inject
    lateinit var logger: Logger

    @Inject
    lateinit var fromFeedNavActions: FromFeedNavActions

    @Inject
    lateinit var viewModelFactory: FeedViewModel.Factory

    private val component by lazy {
        createGraphFactory<FeedActivityComponent.Factory>().create(
            root = this,
            serviceProvider = applicationContext.resolveServiceProvider()
        )
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T> resolve(): T = component as T

    override fun onCreate(savedInstanceState: Bundle?) {
        AnvilInjection.inject(this)
        super.onCreate(savedInstanceState)

        logger.log("onCreate")
        viewModelFactory.create(lifecycleScope)
        enableEdgeToEdge()
        setContent {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.weight(1f))

                Text(
                    text = "Hello Feed!",
                    color = Color.White,
                    fontSize = 32.sp
                )

                Spacer(Modifier.height(24.dp))

                Button(
                    onClick = {
                        startActivity(fromFeedNavActions.openUserProfile())
                    },
                    shape = CircleShape,
                    colors = ButtonColors(
                        containerColor = Color.Blue,
                        contentColor = Color.White,
                        disabledContainerColor = Color.Blue,
                        disabledContentColor = Color.White,
                    )
                ) {
                    Text(
                        text = "Open User Profile",
                        fontSize = 24.sp
                    )
                }

                Spacer(Modifier.weight(1f))
            }
        }
    }

    @ContributesTo(AppScope::class)
    interface ServiceProvider {
        val logger: Logger
        val fromFeedNavActions: FromFeedNavActions
    }
}
