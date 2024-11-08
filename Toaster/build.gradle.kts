plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    id("maven-publish")
}

android {
    namespace = "com.example.toaster"
    compileSdk = 35

    defaultConfig {
        minSdk = 24

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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}


afterEvaluate {
    publishing{
        publications {
            create<MavenPublication>("maven") {
                from(components["release"])
                //com.github.<<your GitHub user name>>
                groupId = "com.github.eng-ahmed-younis"
                //name of your library.
                artifactId = "toaster"
                version = "1.2"
            }
        }
    }
}

    /*    from components . release
                        groupId = '<<group id>>'
                artifactId = '<<artifact id>>'
                version = '<<version>>'

            release(MavenPublication) {
                from components . release
                        groupId = '<<group id>>'
                artifactId = '<<artifact id>>'
                version = '<<version>>'
            }*/