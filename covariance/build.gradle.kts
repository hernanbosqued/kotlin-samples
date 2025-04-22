// gradle command-line run:
// gradle run --args="hernan atlanta"

// jar command-line run:
// java -jar hello-1.0.0.jar hernan atlanta

plugins {
    application
}

application {
//    mainClassName = "hernanbosqued.samples.MainKt"
}

dependencies {
    api(project(":library"))
    implementation("junit:junit:4.12")
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
