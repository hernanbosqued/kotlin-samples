//gradle command-line run:
//gradle run --args="hernan atlanta"

//jar command-line run:
//java -jar hello-1.0.0.jar hernan atlanta

plugins {
    application
}

dependencies {
    api(project(":library"))
    implementation("junit:junit:4.13.1")
}

tasks.jar {
    manifest {
        attributes["Main-Class"] = "hernanbosqued.modelado.MainKt"
    }

    configurations["compileClasspath"].forEach { file: File ->
        if(file.isFile){
            from(zipTree(file.absoluteFile))
        }
    }
}