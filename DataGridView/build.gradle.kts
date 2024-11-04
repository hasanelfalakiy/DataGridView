plugins {
    id("com.android.library")
    id("maven-publish")
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

android {
    namespace = "jkas.datagridview"
    compileSdk = 34
    buildToolsVersion = "34.0.4"
    
    defaultConfig {
        minSdk = 21
        targetSdk = 34
    }
}

dependencies {
    // No dependencies needed
}