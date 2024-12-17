import java.io.FileInputStream
import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.ksp)
    alias(libs.plugins.poeditor)
    alias(libs.plugins.secrets.vault.plugin)
    alias(libs.plugins.gmsgoogleservices)
    alias(libs.plugins.crashlytics)
}

val keystoreProperties = Properties()
val keystorePropertiesFile = rootProject.file("./local.properties")
val canSignWithKeystore = keystorePropertiesFile.exists()
if (canSignWithKeystore) {
    keystoreProperties.load(FileInputStream(keystorePropertiesFile))
}
poEditor {
    apiToken.set(keystoreProperties["POEDITOR_API_TOKEN"] as String)
    projectId.set((keystoreProperties["POEDITOR_PROJECT_ID"] as String).toInt())
    defaultLang.set("en")
    unescapeHtmlTags.set(false)
    order.set("terms")
}

android {
    namespace = "com.abdelrahman.raafat.budget.tracker"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.abdelrahman.raafat.budget.tracker"
        minSdk = 26
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    externalNativeBuild {
        cmake {
            path("src/main/cpp/CMakeLists.txt")
        }
    }

    signingConfigs {
        create("release") {
            storeFile = file("$rootDir/${keystoreProperties["PROD_STORE_FILE"] as String}")
            storePassword = keystoreProperties["PROD_STORE_PASSWORD"] as String
            keyAlias = keystoreProperties["PROD_KEY_ALIAS"] as String
            keyPassword = keystoreProperties["PROD_KEY_PASSWORD"] as String
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro",
            )
            signingConfig = signingConfigs.getByName("release")
            buildConfigField("boolean", "IS_DEBUG", "false")
        }

        debug {
            buildConfigField("boolean", "IS_DEBUG", "true")
            applicationIdSuffix = ".debug"
            resValue("string", "app_name", "Budget Tracker debug")
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        buildConfig = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.lottie.compose)
    implementation(libs.androidx.navigation.compose)
    implementation(libs.androidx.lifecycle.process)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation(libs.androidx.datastore.preferences)
    implementation(libs.kotlinx.serialization.json)

    // Room
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    ksp(libs.androidx.room.compiler)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.crashlytics)
    implementation(libs.firebase.analytics)
}
