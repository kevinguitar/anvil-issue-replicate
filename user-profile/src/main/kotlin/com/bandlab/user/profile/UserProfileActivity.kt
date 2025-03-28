package com.bandlab.user.profile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.bandlab.common.AnvilInjection
import javax.inject.Inject

class UserProfileActivity : ComponentActivity() {

    @Inject
    lateinit var lifecycleManager: LifecycleManager

    override fun onCreate(savedInstanceState: Bundle?) {
        AnvilInjection.inject(this)
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        setContent {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Hello User Profile!",
                    color = Color.White,
                    fontSize = 32.sp
                )
            }
        }
    }
}
