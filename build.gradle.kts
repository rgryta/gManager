plugins {
    id("com.android.application") version "7.2.1" apply false
    id("com.android.library") version "7.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.6.21" apply false
}

buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath("io.realm:realm-gradle-plugin:5.1.0")
    }
}


val gName by extra("gManager")
val gPackageName by extra("eu.rgryta.gmanager")
val gSdk by extra(32)
val gMinSdk by extra(28)

val gVApp by extra(1)
val gVNameApp by extra("0.1")

val gVLFiles by extra(1)
val gVNameLFiles by extra("0.1")

val gVLRealmDB by extra(1)
val gVNameLRealmDB by extra("0.1")