//gradle command-line run:
//gradle run --args="hernan atlanta"

//jar command-line run:
//java -jar hello-1.0.0.jar hernan atlanta

plugins {
    application
}

dependencies {
    api(project(":library"))
    implementation("org.processing:core:3.3.6")
}

tasks.jar {
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE

    manifest {
        attributes["Main-Class"] = "hernanbosqued.samples.processing.MainKt"
    }

    configurations["compileClasspath"].forEach { file: File ->
        if(file.isFile){
            from(zipTree(file.absoluteFile))
        }
    }
}