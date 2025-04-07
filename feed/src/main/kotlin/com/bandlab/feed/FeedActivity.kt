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
import com.bandlab.common.AnvilInjection
import com.bandlab.common.AppScope
import com.bandlab.common.HasServiceProvider
import com.bandlab.common.Logger
import me.tatarka.inject.annotations.Inject
import software.amazon.lastmile.kotlin.inject.anvil.ContributesTo
import kotlin.math.log

class FeedActivity : ComponentActivity() { //, HasServiceProvider {

    lateinit var factory: FeedActivityComponent.Factory
    lateinit var logger: Logger
    lateinit var fromFeedNavActions: FromFeedNavActions

    @Inject
    fun injectMembers(
        factory: FeedActivityComponent.Factory,
        logger: Logger,
        fromFeedNavActions: FromFeedNavActions
    ) {
        this.logger = logger
        this.fromFeedNavActions = fromFeedNavActions
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val component = factory.create("feed")
        logger.log("FeedActivity onCreate")
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

//    @ContributesTo(AppScope::class)
//    interface ServiceProvider {
//        fun logger(): Logger
//        fun fromFeedNavActions(): FromFeedNavActions
//    }
}
