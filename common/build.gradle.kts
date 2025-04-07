plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.example.anvilissuereplicate"
    compileSdk = 35
    defaultConfig.minSdk = 24

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(libs.androidx.activity.compose)

    implementation(libs.kotlin.inject.runtime)
    implementation(libs.kotlin.inject.anvil.runtime)
    ksp(libs.kotlin.inject.ksp)
    ksp(libs.kotlin.inject.anvil.compiler)
}
