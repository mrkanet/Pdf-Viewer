plugins {
    id("com.android.application") version "8.10.0" apply false
    id("com.android.library") version "8.10.0" apply false
    id("org.jetbrains.kotlin.android") version "1.9.24" apply false
}

subprojects {
    configurations.configureEach {
        resolutionStrategy {
            force(
                "org.jetbrains.kotlin:kotlin-stdlib:1.9.24",
                "org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.24",
                "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.24",
                "org.jetbrains.kotlin:kotlin-reflect:1.9.24"
            )
        }
    }
}
