package dependencies

object Dep {
    object Gradle {
        const val androidGradle = "com.android.tools.build:gradle:3.6.1"
        const val kotlinGradlePlugin =
            "org.jetbrains.kotlin:kotlin-gradle-plugin:${Project.Kotlin.version}"
    }

    object Kotlin {
        const val stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Project.Kotlin.version}"
    }

    object AndroidX {
        const val appcompat = "androidx.appcompat:appcompat:1.1.0"
        const val coreKtx = "androidx.core:core-ktx:1.2.0"
        const val legacySupport = "androidx.legacy:legacy-support-v4:1.0.0"

        const val constraintLayout = "androidx.constraintlayout:constraintlayout:1.1.3"
        const val cardView = "androidx.cardview:cardview:1.0.0"
    }

    object Android {
        const val palette = "com.android.support:palette-v7:29.0.0"
    }

    object Lifecycle {
        const val extensions = "androidx.lifecycle:lifecycle-extensions:2.2.0"
        const val viewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0"
    }

    object Navigation {
        const val fragmentKtx = "androidx.navigation:navigation-fragment-ktx:2.2.1"
        const val uiKtx = "androidx.navigation:navigation-ui-ktx:2.2.1"
        const val safeArgsGradlePlugin =
            "androidx.navigation:navigation-safe-args-gradle-plugin:2.3.0-alpha03"
    }

    object Coroutine {
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.4"
    }

    object Epoxy {
        const val epoxy = "com.airbnb.android:epoxy:3.8.0"
        const val processor = "com.airbnb.android:epoxy-processor:3.8.0"
        const val dataBinding = "com.airbnb.android:epoxy-databinding:3.8.0"
    }

    object Test {
        const val junit = "junit:junit:4.12"
        const val androidXJunit = "androidx.test.ext:junit:1.1.1"
        const val espresso = "androidx.test.espresso:espresso-core:3.2.0"
    }
}