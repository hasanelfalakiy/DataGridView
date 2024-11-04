plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    
    id("maven-publish")
}

android {
    namespace = "jkas.datagridview"
    compileSdk = 34
    
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
    
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {
    // No dependencies needed
}

afterEvaluate {
    publishing {
        publications {
            create<MavenPublication>("release") {
                from(components["release"])

                groupId = "com.github.hasanelfalakiy"
                artifactId = "DataGridView"
                version = "1.0-SNAPSHOT"
            }
        }
    }
}
