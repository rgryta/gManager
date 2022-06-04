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
    val gVLFiles: Int by rootProject.extra
    val gVNameLFiles: String by rootProject.extra

    compileSdk = gSdk

    defaultConfig {
        applicationId = gPackageName.plus(".lib.files")
        targetSdk = gSdk
        minSdk = gMinSdk

        versionCode = gVLFiles
        versionName = gVNameLFiles

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


    /*sourceSets.getByName("main") {
        res.setSrcDirs(listOf(
            "src/main/res/layout/lfiles",
            "src/main/res/values",

        ))
    }*/

    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions.jvmTarget = "1.8"
}

dependencies {
    implementation(project(":lib-core"))


    testImplementation("junit:junit:4.13.2")

    androidTestImplementation("androidx.test.ext:junit:1.1.3")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.4.0")
}

