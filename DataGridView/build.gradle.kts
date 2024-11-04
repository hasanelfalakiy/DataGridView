plugins {
    id("com.android.library")
    id("maven-publish")
}

android {
    namespace = "jkas.datagridview"
    compileSdk = 34
    buildToolsVersion = "34.0.4"
    
    defaultConfig {
        minSdk = 21
        targetSdk = 34
        
        buildTypes {
            release {
                isMinifyEnabled = false
                proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            }
        }
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