plugins {
    java
    id("maven-publish")
    id("com.github.johnrengelman.shadow") version ("7.1.2")
}

val libs = "net.shibacraft.api.libs"

group = "net.shibacraft"
version = "0.0.1"

configurations.all {
    resolutionStrategy.cacheChangingModulesFor(0, "seconds")
}

allprojects {
    plugins.apply("maven-publish")

    publishing {
        publications {
            create<MavenPublication>("maven") {
                groupId = "${project.group}"
                artifactId = project.name
                version = "${project.version}"

                from(components["java"])
            }
        }
    }
}

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.google.inject:guice:5.1.0")
    implementation("net.md-5:specialsource-maven-plugin:1.2.4")
    compileOnly("org.spigotmc:spigot-api:1.19.2-R0.1-SNAPSHOT")
    //compileOnly("com.google.inject:guice:5.0.1")
    //implementation("net.byteflux:libby-bukkit:1.1.5")
    //implementation("com.github.simplix-softworks:simplixstorage:3.2.4")
    //implementation("org.bstats:bstats-bukkit:3.0.0")
    //implementation("me.fixeddev:commandflow-bukkit:0.5.2")
    //compileOnly("org.projectlombok:lombok:1.18.24")
    //annotationProcessor("org.projectlombok:lombok:1.18.24")
}

tasks {
    java {
        toolchain {
            languageVersion.set(JavaLanguageVersion.of(8))
        }
    }
    withType<JavaCompile> {
        options.encoding = "UTF-8"
    }
    shadowJar {
        delete(file("${project.buildDir}"))
        archiveClassifier.set("")
        archiveFileName.set("${project.name}-${project.version}.jar")
        //relocate("me.fixeddev.commandflow", "$libs.cmdFlow")
        //relocate("net.kyori.text", "$libs.kyori")
        //relocate("org.bstats", "$libs.bStats")
        //relocate("de.leonhard.storage", "$libs.leonhardStorage")
        //relocate("org.checkerframework", "$libs.jetbrains")
        //relocate("org.jetbrains.annotations", "$libs.jetbrains")
        minimize()
    }
    build {
        dependsOn(shadowJar)
    }
    processResources {
        filesMatching("plugin.yml") {
            expand("v" to project.version)
        }
    }

}