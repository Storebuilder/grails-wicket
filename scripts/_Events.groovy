
eventCreateWarStart = { warName, stagingDir ->

    println "Copying Wicket resources..."

    ant.copy(todir: "${stagingDir}/WEB-INF/classes", overwrite: true) {
        fileset(dir: "${basedir}/grails-app/pages", includes: "**") {
            exclude(name: "**/*.groovy")
        }
    }

}

