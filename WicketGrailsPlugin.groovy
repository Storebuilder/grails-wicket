import org.apache.wicket.Application
import org.codehaus.groovy.grails.commons.ConfigurationHolder

class WicketGrailsPlugin {
    def version = '1.4.9'
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

        servlets + {
            servlet {
                'servlet-name'('wicket')
                'servlet-class'('org.apache.wicket.protocol.http.WicketServlet')
                'init-param' {
                    'param-name'('applicationFactoryClassName')
                    'param-value'('org.apache.wicket.spring.SpringWebApplicationFactory')
                }
                'load-on-startup'(1)
            }
        }

        def mappings = xml.'servlet-mapping'[0]
        mappings + {
            'servlet-mapping' {
                'servlet-name'('wicket')
                'url-pattern'(ConfigurationHolder.config.grails.wicket.urlPattern ?: '/app/*')
            }
        }
    }

    def onChange = { event ->
        restartContainer()
    }
}
