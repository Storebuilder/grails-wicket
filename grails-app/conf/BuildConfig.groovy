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
       
        //To download publicly published plugins & grails libs
        mavenRepo "http://repo.grails.org/grails/core"
        mavenRepo "http://repo.grails.org/grails/plugins"
        //grailsPlugins()
        //grailsHome()
        grailsCentral()

        // uncomment the below to enable remote dependency resolution
        // from public Maven repositories
        //mavenLocal()
        mavenCentral()
        //mavenRepo "http://wicketstuff.org/maven/repository"
        //mavenRepo "http://download.java.net/maven/1"
        //mavenRepo "http://download.java.net/maven/2"
        //mavenRepo "http://repository.jboss.com/maven2/"

    }

    dependencies {
        compile('org.apache.wicket:wicket:6.28.0') {
            excludes('junit')
            excludes('log4j')
        }
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
            
        }
        compile('org.wicketstuff:wicketstuff-restannotations:6.28.0'){

        }
        compile('org.wicketstuff:wicketstuff-restannotations-json:6.28.0'){

        }
    }
}