plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.anvil)
}

android {
    namespace = "com.example.anvilissuereplicate"
    compileSdk = 35
    defaultConfig.minSdk = 24

    kotlinOptions {
        jvmTarget = "1.8"
    }
}

anvil {
    trackSourceFiles.set(true)
    generateDaggerFactories.set(true)
    useKsp(
        contributesAndFactoryGeneration = true,
        componentMerging = true
    )
}

dependencies {
    implementation(libs.androidx.activity.compose)
    implementation(libs.dagger)
}
