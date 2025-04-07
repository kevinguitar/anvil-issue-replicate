package com.bandlab.common

import androidx.activity.ComponentActivity

object AnvilInjection {

    fun <T : ComponentActivity> inject(activity: T) {
        try {
            val injector = activity.resolveServiceProvider<AnvilInjector<T>>()
            injector.inject(activity)
            return
        } catch (e: Exception) {
            e.toString()
        }

        val injectors = activity
            .resolveServiceProvider<AnvilAndroidInjectorProvider>()
            .dispatchingAnvilInjector()

        val injector = injectors[activity::class]
            ?: error(
                """
                    No injector found for ${activity::class.qualifiedName}, 
                    you probably forget to annotate activity with @ContributesInjector
                """.trimIndent()
            )

        @Suppress("UNCHECKED_CAST")
        (injector as AnvilInjector.Factory<ComponentActivity>)
            .create(activity)
            .inject(activity)
    }
}