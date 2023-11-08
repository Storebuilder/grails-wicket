grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"

grails.project.dependency.resolver = "maven" // or ivy

grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {

        //To download publicly published plugins & grails libs
        //grailsCentral()
        //grailsPlugins()
        //grailsHome()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        mavenLocal()
        //mavenCentral() // need to comment this to use https for mavenRepo
        mavenRepo "https://repo1.maven.org/maven2"
        mavenRepo "https://repo.grails.org/grails/core"
        mavenRepo "https://repo.grails.org/grails/plugins"
        //mavenRepo "http://wicketstuff.org/maven/repository"
        //mavenRepo "http://download.java.net/maven/1"
        //mavenRepo "http://download.java.net/maven/2"
        //mavenRepo "http://repository.jboss.com/maven2/"

    }

    dependencies {
        //compile('org.grails.plugins:hibernate:2.2.4')
        compile('org.objenesis:objenesis:1.4') {
            excludes('commons-logging')
        }
        //compile('org.apache.wicket:wicket:6.28.0') {
        //    excludes('junit')
        //    excludes('log4j')
        //}
        compile('org.apache.wicket:wicket-core:6.28.0') {
            excludes('junit')
            excludes('log4j')
        }
        compile('org.apache.wicket:wicket-extensions:6.28.0') {
            excludes('junit')
            excludes('log4j')
        }
        compile('org.apache.wicket:wicket-datetime:6.28.0') {
            excludes('junit')
            excludes('log4j')
        }
        compile('org.apache.wicket:wicket-ioc:6.28.0') {
            excludes('junit')
            excludes('log4j')
        }
        compile('org.apache.wicket:wicket-spring:6.28.0') {
            excludes('spring')
            excludes('junit')
            excludes('log4j')
        }
        compile('org.wicketstuff:wicketstuff-flot:6.28.0'){
            excludes('log4j')
            excludes('junit')
            excludes('slf4j-log4j12')

        }
        compile('org.wicketstuff:wicketstuff-restannotations:6.28.0'){

        }
        compile('org.wicketstuff:wicketstuff-restannotations-json:6.28.0'){

        }
    }

    plugins {
        build(":release:2.2.1",
                ":rest-client-builder:1.0.3") {
            export = false
        }
    }
}