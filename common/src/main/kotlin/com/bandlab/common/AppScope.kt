package com.bandlab.common

import me.tatarka.inject.annotations.Scope

interface AppScope

@Scope
annotation class Singleton

@Scope
annotation class ActivityScope
