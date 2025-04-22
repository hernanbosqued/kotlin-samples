// gradle command-line run:
// gradle run --args="hernan atlanta"

// jar command-line run:
// java -jar hello-1.0.0.jar hernan atlanta

plugins {
    application
}

dependencies {
    api(project(":library"))
    implementation("com.google.code.gson:gson:2.8.9")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "hernanbosqued.samples.MainKt"
    }

    configurations["compileClasspath"].forEach { file: File ->
        if (file.isFile) {
            from(zipTree(file.absoluteFile))
        }
    }
}
