package dependencies

object Android {
    const val compileSdkVersion = 29
    const val buildToolVersion = "29.0.3"

    object DefaultConfig {
        const val applicationId = "com.github.yasukotelin.androidfeatureexample"
        const val minSdkVersion = 23
        const val targetSdkVersion = 29

        private const val versionMajor = 1
        private const val versionMinor = 1
        private const val versionPatch = 0
        private const val versionOffset = 0
        const val versionCode =
            ((1 + versionMajor) * 10000 + versionMinor * 100 + versionPatch) * 100 + versionOffset
        const val versionName = "$versionMajor.$versionMinor.$versionPatch"

        const val testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}