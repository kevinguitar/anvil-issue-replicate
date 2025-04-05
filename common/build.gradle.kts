plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.metro)
}

android {
    namespace = "com.example.anvilissuereplicate"
    compileSdk = 35
    defaultConfig.minSdk = 24

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

metro {
    interop {
        includeDagger(includeJakarta = false)
        includeAnvil(includeKotlinInjectAnvil = false)
    }
}

dependencies {
    implementation(libs.androidx.activity.compose)
}
