plugins {
    alias(libs.plugins.android.library)
    
}

android {
    namespace = "jkas.datagridview"
    compileSdk = 34
    buildToolsVersion = "34.0.4"
    
    defaultConfig {
        minSdk = 21
        targetSdk = 34
    }
    
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    
}

dependencies {
    // No dependencies needed
}

