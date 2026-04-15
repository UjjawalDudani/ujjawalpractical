plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("org.jetbrains.kotlin.kapt")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.example.ujjawalpractical"

    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.ujjawalpractical"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    /*kotlinOptions {
        jvmTarget = "17"
    }*/

    buildFeatures {
        viewBinding = true
    }
}

/*
dependencies {

    // Core
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.constraintlayout)

    // Activity
    implementation("androidx.activity:activity-ktx:1.8.2")

    // RecyclerView (XML UI)
    implementation("androidx.recyclerview:recyclerview:1.3.2")

    // Lifecycle (MVVM)
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.7.0")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Hilt (Dependency Injection)
    implementation("com.google.dagger:hilt-android:2.50")
    kapt("com.google.dagger:hilt-compiler:2.50")

    // Retrofit (API)
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")

    // OkHttp (Logging)
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    // Paging 3 (RecyclerView pagination)
    implementation("androidx.paging:paging-runtime:3.2.1")

    // Room (Database - Watchlist)
    implementation("androidx.room:room-runtime:2.6.1")
    kapt("androidx.room:room-compiler:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    // Image Loading (XML)
    implementation("com.github.bumptech.glide:glide:4.16.0")
    kapt("com.github.bumptech.glide:compiler:4.16.0")

    // Testing
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

}*/

dependencies {

    // Core

        implementation("androidx.core:core-ktx:1.12.0")
        implementation("androidx.core:core:1.12.0")
    implementation("com.google.android.material:material:1.11.0")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:2.11.0")
    implementation("com.squareup.retrofit2:converter-gson:2.11.0")

    // OkHttp
    implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.4")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")

    // RecyclerView
    implementation("androidx.recyclerview:recyclerview:1.3.2")

    // Paging 3
    implementation("androidx.paging:paging-runtime:3.3.2")

    // Coil (image loading)
    implementation("io.coil-kt:coil:2.6.0")

    implementation("androidx.activity:activity-ktx:1.9.3")

    // Hilt
    implementation("com.google.dagger:hilt-android:2.51.1")
    kapt("com.google.dagger:hilt-compiler:2.51.1")

    // Paging 3
    implementation("androidx.paging:paging-runtime:3.3.2")

    // Lifecycle
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.4")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.8.4")

    // Room
    implementation("androidx.room:room-runtime:2.6.1")
    implementation("androidx.room:room-ktx:2.6.1")

    kapt("androidx.room:room-compiler:2.6.1")

// Unit Testing
    testImplementation("junit:junit:4.13.2")
// Coroutines testing
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.7.3")
// Mocking
    testImplementation("io.mockk:mockk:1.13.5")
// Paging test support
    testImplementation("androidx.paging:paging-common:3.3.2")
// Architecture components testing
    testImplementation("androidx.arch.core:core-testing:2.2.0")
}