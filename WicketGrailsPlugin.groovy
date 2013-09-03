import org.apache.wicket.Application
import org.codehaus.groovy.grails.commons.ConfigurationHolder

class WicketGrailsPlugin {
    def version = '1.5.2'
    def author = "Narender Loganathan. previously : Lee Butts & Graeme Rocher"
    def title = "Provides integration between Grails and the Wicket framework"
    def description = """
A plug-in that makes Wicket (http://wicket.sourceforge.net/) the default view rendering framework for Grails. Wicket is a
component oriented framework that, like Grails, embraces convention-over-configuration approaches.
	"""
    def documentation = "http://grails.org/plugin/wicket"

    def watchedResources = ["file:./grails-app/pages/**/*.groovy",
            "file:./grails-app/pages/**/*.properties",
            "file:./grails-app/pages/**/*.css",
            "file:./grails-app/pages/**/*.xml",
            "file:./grails-app/conf/WicketApplication.groovy"]

    def grailsVersion = "1.3 > *"

    def doWithSpring = {

        def applicationClass = application.allClasses.find { Application.class.isAssignableFrom(it) }

        if (applicationClass) {
            applicationBean(applicationClass)
        }

        if (!application.warDeployed) {
            def rootLoader = getClass().classLoader.rootLoader
            URL viewsDir = new File("./grails-app/views").toURL()
            URL pagesDir = new File("./grails-app/pages").toURL()
            rootLoader.addURL(viewsDir)
            rootLoader.addURL(pagesDir)
        }
    }

    def doWithWebDescriptor = { xml ->
        def servlets = xml.servlet[0]


        /*
           TIP: If you want to change the URL pattern from  "/app/*" you need to change in 2 places below.
           Once in "filterMappingUrlPattern"
           And also in the filter-mapping for "wicket" filter

           Helpful resources:
           1. 'param-name'('applicationClassName')
                See web.xml section. http://wicket.apache.org/learn/examples/helloworld.html
                Note: WicketApplication class refers to file in Configuration inside the app where this plugin is installed not the one in this plugin itself.
           2. 'param-name'('applicationFactoryClassName')
                For tip on adding SpringWebApplicationFactory if using @SpringBean
                https://cwiki.apache.org/confluence/display/WICKET/SpringBean+outside+Wicket
                P.S: info from official api docs was confusing & did not work : http://wicket.apache.org/apidocs/1.5/org/apache/wicket/spring/SpringWebApplicationFactory.html
           3.  'param-name'('filterMappingUrlPattern')
                Helped crack the below error : http://stackoverflow.com/questions/5494395/how-to-use-guice-servlet-with-wicket
                     java.lang.IllegalStateException: filter path was not configured
	                    at org.apache.wicket.protocol.http.WicketFilter.processRequest(WicketFilter.java:141)

         */
        def filters = xml.filter[0]

        filters + {
            filter {
                'filter-name'('wicket')
                'filter-class'('org.apache.wicket.protocol.http.WicketFilter')
                'init-param' {
                    'param-name'('applicationClassName')
                    'param-value'('WicketApplication')
                }
                'init-param' {
                    'param-name'('applicationFactoryClassName')
                    'param-value'('org.apache.wicket.spring.SpringWebApplicationFactory')
                }
                'init-param' {
                    'param-name'('filterMappingUrlPattern')
                    'param-value'('/*')
                }
            }
        }

        def mappings = xml.'filter-mapping'[0]
        mappings + {
            'filter-mapping' {
                'filter-name'('wicket')
                'url-pattern'(ConfigurationHolder.config.grails.wicket.urlPattern ?: '/*')
            }
        }
    }

    def onChange = { event ->
        restartContainer()
    }
}
