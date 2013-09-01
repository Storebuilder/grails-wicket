grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        mavenCentral()
        mavenRepo "http://wicketstuff.org/maven/repository"
        mavenRepo "http://download.java.net/maven/1"
        mavenRepo "http://download.java.net/maven/2"
        mavenRepo "http://repository.jboss.com/maven2/"

    }

    dependencies {
        compile('org.apache.wicket:wicket:1.5.2') {
            excludes('junit')
            excludes('log4j')
    }
        compile('org.apache.wicket:wicket-extensions:1.5.2') {
            excludes('junit')
            excludes('log4j')
}
        compile('org.apache.wicket:wicket-ioc:1.5.2') {
            excludes('junit')
            excludes('log4j')
        }
        compile('org.apache.wicket:wicket-spring:1.5.2') {
            excludes('spring')
            excludes('junit')
            excludes('log4j')
        }
    }
}