// gradle command-line run:
// gradle run --args="hernan atlanta"

// jar command-line run:
// java -jar hello-1.0.0.jar hernan atlanta

plugins {
    application
}

dependencies {
    api(project(":library"))
    implementation("io.ktor:ktor-server-core:1.6.7")
    implementation("io.ktor:ktor-server-netty:1.6.7")
    implementation("ch.qos.logback:logback-classic:1.2.5")
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    manifest {
        attributes["Main-Class"] = "hernanbosqued.samples.MainKt"
    }

    configurations["compileClasspath"].forEach { file: File ->
        if (file.isFile) {
            from(zipTree(file.absoluteFile))
        }
    }
}
