import com.vanniktech.maven.publish.AndroidSingleVariantLibrary
import com.vanniktech.maven.publish.SonatypeHost

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    id("kotlin-parcelize")
    id("org.jetbrains.dokka") version "1.9.20"
    id("com.vanniktech.maven.publish") version "0.28.0"
}

android {
    namespace = "com.rajat.pdfviewer"
    compileSdk = 35

    defaultConfig {
        minSdk = 21
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }
    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    kotlinOptions {
        jvmTarget = "17"
    }

    kotlin {
        jvmToolchain(17)
    }

    buildFeatures {
        viewBinding = true
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.14"
    }

}

dependencies {
    implementation("androidx.compose.material3:material3")
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation("androidx.core:core-ktx:1.15.0")
    implementation("androidx.appcompat:appcompat:1.7.0")
    implementation("androidx.recyclerview:recyclerview:1.4.0")
    implementation("androidx.constraintlayout:constraintlayout:2.2.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.1")
    implementation("com.google.android.material:material:1.8.0")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.2.1")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.6.1")
    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.8.7")
    implementation("androidx.lifecycle:lifecycle-runtime-compose:2.8.7")
    implementation("androidx.activity:activity-ktx:1.10.0")
    // compose
    implementation(platform("androidx.compose:compose-bom:2024.06.00"))
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.06.00"))
    implementation("androidx.compose.ui:ui")
    // Android Studio Preview support
    implementation("androidx.compose.ui:ui-tooling-preview")
    debugImplementation("androidx.compose.ui:ui-tooling")
    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
    implementation("androidx.activity:activity-compose:1.10.0")
    implementation("com.squareup.okhttp3:okhttp:4.12.0")
}

mavenPublishing {
    configure(
        AndroidSingleVariantLibrary(
            // the published variant
            variant = "release",
            // whether to publish a sources jar
            sourcesJar = true,
        )
    )

    publishToMavenCentral(SonatypeHost.CENTRAL_PORTAL)
    signAllPublications()

    coordinates("io.github.afreakyelf", "Pdf-Viewer", "2.3.7")

    pom {
        name.set("PDF Viewer")
        description.set("A PDF viewing library for Android")
        url.set("https://github.com/afreakyelf/pdfviewer")
        licenses {
            license {
                name.set("MIT License")
                url.set("https://opensource.org/licenses/MIT")
            }
        }
        developers {
            developer {
                id.set("afreakyelf")
                name.set("Rajat Mittal")
                email.set("rjmittal07@gmail.com")
            }
        }
        scm {
            connection.set("scm:git:git://github.com/afreakyelf/pdfviewer.git")
            developerConnection.set("scm:git:ssh://github.com/afreakyelf/pdfviewer.git")
            url.set("https://github.com/afreakyelf/pdfviewer")
        }
    }

}