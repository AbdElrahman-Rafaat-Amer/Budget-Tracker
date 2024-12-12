pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
        maven { url = uri("https://jitpack.io") }
        maven { url = java.net.URI("https://jitpack.io") }
    }
    resolutionStrategy {
        eachPlugin {
            // Add custom plugin ID for the PoEditor plugin.
            // This is required because the plugin is not published in the Gradle plugin portal.
            if (requested.id.id == "com.hyperdevs.poeditor") {
                useModule("com.github.hyperdevs-team:poeditor-android-gradle-plugin:${requested.version}")
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Budget-Tracker"
include(":app")
