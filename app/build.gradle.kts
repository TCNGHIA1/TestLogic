plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.testlogic"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.testlogic"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)


    // Java language implementation
    implementation(libs.navigation.fragment)
    implementation(libs.navigation.ui)

    // Testing Navigation
    androidTestImplementation(libs.navigation.testing)

    // Retrofit
    implementation(libs.retrofit)
    implementation(libs.converter.gson)
    implementation(libs.logging.interceptor)

    // Room
    implementation(libs.room.runtime)
    annotationProcessor(libs.room.compiler)
    testImplementation(libs.room.testing)

    // SwiperRefreshLayout
    implementation(libs.swiperefreshlayout)

    // Glide
    implementation(libs.glide)
}