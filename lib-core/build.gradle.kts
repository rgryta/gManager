plugins {
    id("com.android.library")
    kotlin("android")
}

android {
    lint {
        abortOnError = false
        baseline = rootProject.file("lint-baseline.xml")
    }

    val gSdk: Int by rootProject.extra
    val gMinSdk: Int by rootProject.extra




    compileSdk = gSdk

    defaultConfig {

        targetSdk = gSdk
        minSdk = gMinSdk



        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    api("androidx.core:core-ktx:1.8.0")
    api("androidx.appcompat:appcompat:1.4.2")
    api("androidx.fragment:fragment-ktx:1.4.1")
    api("androidx.constraintlayout:constraintlayout:2.1.4")
    api("org.jetbrains.kotlin:kotlin-reflect:1.6.21")

    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}