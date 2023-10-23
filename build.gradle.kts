plugins {
    id("java-library")
    id("maven-publish")
}

group = "ru.ekazantsev"
version = "1.0.0"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("maven") {
            from(components["java"])
            pom {
                groupId = project.group.toString()
                artifactId = project.name
                version = project.version.toString()
            }
        }
    }
    repositories {
        mavenLocal()
    }
}

repositories {
    mavenCentral()
    mavenLocal()
}

dependencies {
    implementation ("com.j256.ormlite:ormlite-jdbc:6.1")
    implementation ("com.h2database:h2:2.1.214")
    implementation ("com.fasterxml.jackson.core:jackson-databind:2.15.2")

    testImplementation ("ch.qos.logback:logback-classic:1.4.11")
    testImplementation ("org.codehaus.groovy:groovy-all:3.0.19")
    testImplementation ("org.jetbrains.kotlin:kotlin-test")
}

