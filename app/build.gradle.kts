import com.android.build.api.dsl.ApplicationExtension

plugins {
    id("com.android.application")
    id("org.lsposed.lsparanoid")
}

lsparanoid {
    seed = 114514
    includeDependencies = true
    classFilter = { true }
    variantFilter = { true }
}

    namespace = "nep.timeline.freezer.script"
    compileSdk = 36

    defaultConfig {
        applicationId = "nep.timeline.freezer.script"
        minSdk = 28
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"
        multiDexEnabled = false
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {
        buildConfig = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_25
        targetCompatibility = JavaVersion.VERSION_25
    }

    lint {
        abortOnError = false
        checkReleaseBuilds = false
    }

    packaging {
        resources {
            excludes += listOf(
                "META-INF/*.version",
                "META-INF/**/LICENSE.txt",
                "DebugProbesKt.bin",
                "kotlin-tooling-metadata.json"
            )
            pickFirsts += "META-INF/androidx.compose.ui_ui.version"
        }
    }
}

dependencies {
    compileOnly("de.robv.android.xposed:api:82:sources")
    compileOnly("de.robv.android.xposed:api:82")
    compileOnly("commons-io:commons-io:2.21.0")
    compileOnly("dev.rikka.rikkax.parcelablelist:parcelablelist:2.0.1")
    compileOnly("org.lsposed.hiddenapibypass:hiddenapibypass:6.1")
    compileOnly("com.google.code.gson:gson:2.13.2")
    val libsuVersion = "6.0.0"
    compileOnly("com.github.topjohnwu.libsu:core:$libsuVersion")
    compileOnly("com.github.topjohnwu.libsu:service:$libsuVersion")
    compileOnly("com.github.topjohnwu.libsu:io:$libsuVersion")
}