package com.example.anvilissuereplicate

import androidx.activity.ComponentActivity

object AnvilAndroidInjection {

    fun <T : ComponentActivity> inject(activity: T) {
        val appComponent = (activity.application as App).appComponent
        val dispatchingAnvilInjector = (appComponent as AnvilAndroidInjectorProvider)
            .dispatchingAnvilInjector()

        val injector = dispatchingAnvilInjector[activity::class.java]
            ?: error(
                """
                    No injector found for ${activity::class.qualifiedName}, 
                    you probably forget to annotate activity with @ContributesInjector
                """.trimIndent()
            )

        @Suppress("UNCHECKED_CAST")
        (injector as AnvilAndroidInjector.Factory<ComponentActivity>)
            .create(activity)
            .inject(activity)
    }

}