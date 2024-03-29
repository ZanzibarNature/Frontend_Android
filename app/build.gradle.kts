plugins {
    kotlin("kapt")
    kotlin("plugin.serialization")
    id("com.android.application")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.kawatrainingcenter.zanzibarnature"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.kawatrainingcenter.zanzibarnature"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    kapt {
        correctErrorTypes = true
    }

}



dependencies {
    //serializing json
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")

    //xml cardview custom info window
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //loading asyncimage into xml imageview
    implementation("com.github.bumptech.glide:glide:4.12.0")
    annotationProcessor("com.github.bumptech.glide:compiler:4.12.0")

    //shared preferences
    implementation("androidx.datastore:datastore-preferences-rxjava2:1.0.0")
    implementation("androidx.datastore:datastore-preferences-rxjava3:1.0.0")

    //Coil convert imageurl to drawable
    implementation("io.coil-kt:coil:2.5.0")

    //Open Street Map
    implementation("org.osmdroid:osmdroid-android:6.1.17")

    //pager (used for image slider)
    implementation("com.google.accompanist:accompanist-pager:0.23.1")

    //Gson (JSON parsing)
    implementation("com.google.code.gson:gson:2.10.1")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

    //Async Image
    implementation("io.coil-kt:coil-compose:2.5.0")

    //navigation
    implementation("androidx.navigation:navigation-compose:2.7.5")
    implementation("androidx.compose.material:material:1.5.4")

    //dagger/hilt
    implementation("com.google.dagger:hilt-android:2.48")
    implementation("androidx.hilt:hilt-navigation-compose:1.1.0")
    kapt("com.google.dagger:hilt-compiler:2.46")

    //paging
    implementation("androidx.paging:paging-runtime-ktx:3.2.1")
    implementation("androidx.paging:paging-compose:3.2.1")

    //initial
    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.1")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}
