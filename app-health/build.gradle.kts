plugins {
    alias(libs.plugins.kmp.library.convention)
    alias(libs.plugins.android.library)
}

kotlin {
    sourceSets {
        commonMain.dependencies { }
    }
}

android {
    namespace = "com.mifos.app.health"
}
