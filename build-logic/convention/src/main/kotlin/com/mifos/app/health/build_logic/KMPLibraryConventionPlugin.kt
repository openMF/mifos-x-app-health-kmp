
import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.ApplicationProductFlavor
import com.android.build.gradle.LibraryExtension
import com.mifos.app.health.build_logic.FlavorDimension
import com.mifos.app.health.build_logic.MifosFlavor
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import com.mifos.app.health.build_logic.configureKotlinMultiplatform

class KMPLibraryConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.multiplatform")
            }

            configureKotlinMultiplatform()

            extensions.configure<LibraryExtension> {

                defaultConfig.targetSdk = 34
                flavorDimensions += FlavorDimension.contentType.name
                productFlavors {
                    MifosFlavor.values().forEach {
                        create(it.name) {
                            dimension = it.dimension.name

                            if (this@configure is ApplicationExtension && this is ApplicationProductFlavor) {
                                if (it.applicationIdSuffix != null) {
                                    applicationIdSuffix = it.applicationIdSuffix
                                }
                            }
                        }
                    }
                }
                // The resource prefix is derived from the module name,
                // so resources inside ":core:module1" must be prefixed with "core_module1_"
                resourcePrefix = path
                    .split("""\W""".toRegex())
                    .drop(1).distinct()
                    .joinToString(separator = "_")
                    .lowercase() + "_"
            }
        }
    }
}