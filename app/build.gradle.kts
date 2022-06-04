plugins {
    id("com.android.application")
    kotlin("android")
}



android {
    lint {
        abortOnError = false
        baseline = rootProject.file("lint-baseline.xml")
    }

    val gPackageName: String by rootProject.extra
    val gSdk: Int by rootProject.extra
    val gMinSdk: Int by rootProject.extra
    val gVApp: Int by rootProject.extra
    val gVNameApp: String by rootProject.extra

    compileSdk = gSdk

    defaultConfig {
        applicationId = gPackageName
        targetSdk = gSdk
        minSdk = gMinSdk

        versionCode = gVApp
        versionName = gVNameApp
        multiDexEnabled = true
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        viewBinding = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false // Enables code shrinking for the release build type.
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions.jvmTarget = "1.8"
}

dependencies {
    implementation(project(":lib-core"))
    implementation("androidx.multidex:multidex:2.0.1")

    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}