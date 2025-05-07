plugins {
    alias(libs.plugins.kmp.library.convention)
    alias(libs.plugins.android.library)
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(libs.napierLogging)
        }
    }
}

android {
    namespace = "com.mifos.app.health.app-health-logging"
}
