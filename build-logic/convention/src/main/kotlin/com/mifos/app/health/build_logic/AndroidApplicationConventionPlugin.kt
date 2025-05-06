package com.mifos.app.health.build_logic

import com.android.build.api.dsl.ApplicationExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<ApplicationExtension> {
                compileSdk = 35
                defaultConfig {
                    minSdk = 26
                    targetSdk = 34
                }

                compileOptions {
                    // Up to Java 11 APIs are available through desugaring
                    // https://developer.android.com/studio/write/java11-minimal-support-table
                    sourceCompatibility = JavaVersion.VERSION_17
                    targetCompatibility = JavaVersion.VERSION_17
                    isCoreLibraryDesugaringEnabled = true
                }
                configureKotlin()
                @Suppress("UnstableApiUsage")
                testOptions.animationsDisabled = true
            }

        }
    }
}