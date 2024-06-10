plugins {
    kotlin("multiplatform") version "2.0.0"
    id("org.jetbrains.kotlinx.benchmark") version "0.4.11"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    jvmToolchain(21)

    js(IR) { nodejs() }

    sourceSets {
        commonMain {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-benchmark-runtime:0.4.11")
            }
        }
    }
}

benchmark {
    targets {
        register("js")
    }
}
