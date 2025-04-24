plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.android.library)
}

kotlin {
    androidTarget()
    jvm()
    iosX64()
    iosArm64()
    iosSimulatorArm64()
    js(IR) {
        browser()
        nodejs()
    }
    sourceSets {
        commonMain.dependencies {
            implementation(libs.napierLogging)
        }
    }
}

android {
    namespace = "com.mifos.app.health.core"
}
