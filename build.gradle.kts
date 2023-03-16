import org.gradle.api.tasks.testing.logging.TestLogging
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.8.0"
    id("org.jetbrains.compose") version "1.3.0"
    id("com.github.gmazzo.buildconfig") version "3.1.0"
    application
}

subprojects {
    apply(plugin = "com.github.gmazzo.buildconfig")
}

val labNumber = 3

allprojects {
    buildConfig {
        buildConfigField("int", "LAB_NUMBER", "${labNumber}")
    }
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    maven("file://${rootDir}/.m2repo/")
    google()
}

dependencies {
    if (labNumber > 1) {
        implementation(project(":helloworld"))
    }
    implementation(project(":caffe"))
    implementation(project(":juicefactory"))
    implementation("com.diacht.ktest:library:1.0.6")
    testImplementation(kotlin("test"))
}

sourceSets {
    if (labNumber < 2) {
        named("main") {
            java.srcDir("./helloworld/src/main/kotlin/")
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

application {
    mainClass.set("MainKt")
}

tasks.withType<Test> {
    testLogging {
        showCauses = true
        exceptionFormat = org.gradle.api.tasks.testing.logging.TestExceptionFormat.FULL
        events.add(org.gradle.api.tasks.testing.logging.TestLogEvent.STANDARD_OUT)
        events.add(org.gradle.api.tasks.testing.logging.TestLogEvent.STANDARD_ERROR)
        events.add(org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED)
        events.add(org.gradle.api.tasks.testing.logging.TestLogEvent.SKIPPED)
        events.add(org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED)
    }
}