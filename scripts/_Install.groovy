
includeTargets << grailsScript("_PluginDependencies")

def pluginHome = wicketPluginDir.path

Ant.mkdir(dir:"./grails-app/pages")

appFile = new File("./grails-app/conf/WicketApplication.groovy")
if(!appFile.exists()) {
    Ant.copy(file:"$pluginHome/src/templates/WicketApplication.groovy", todir:"./grails-app/conf")
    println "Wicket Application class created at ${appFile.canonicalPath}."
}
homeFile = new File("./grails-app/pages/HomePage.groovy")
if(!homeFile.exists()) {
    Ant.copy(file:"$pluginHome/src/templates/HomePage.groovy", todir:"./grails-app/pages")
    println "Home page class created at ${homeFile.canonicalPath}"
}
homeView = new File("./grails-app/views/HomePage.html")
if(!homeView.exists()) {
    Ant.copy(file:"$pluginHome/src/templates/HomePage.html", todir:"./grails-app/views")
    println "Home page view created at ${homeView.canonicalPath}"
}


