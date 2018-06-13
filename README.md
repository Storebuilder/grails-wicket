grails-wicket (BETA)
=============

Wicket plugin for Grails Framework. If you want to use the Wicket framework as an alternative view rendering technology on top of GORM then this plug-in is for you

Latest Update:
=============
Plugin updated to Wicket version: 6.28.0


For plug-in users: how to install this plugin into your Grails app:
--------------


After checking out this project, Install the plugin into your grails application: 

```
     grails install-plugin $HOME/grails-wicket/grails-wicket-6.28.0.zip
```

For plug-in developers: Steps to package plugin after making changes:
--------------
 
1. in the application root directory: 

```
      grails package-plugin
```

2. This will create a zip file in the root directory with the plugin version: 

```
     grails-wicket-6.28.0.zip
```
     
3. Install the plugin into your grails application: 

```
     grails install-plugin $HOME/grails-wicket/grails-wicket-6.28.0.zip
```


**BACKGROUND:**
--------------

Normally you would install the wicket plugin as 
```
     grails install-plugin wicket
```

But the wicket plugin in subversion uses wicket 1.4.9 and this project upgrades the plugin to wicket 6.28.0 <br>
**The plan is to test it out thoroughly on live projects before upgrading the wicket plugin for everyone to 6.28.0 by publishing it** <br>
Until that happens you can manually install the plugin and play around.

Commit upgrading to wicket 6.28.0 : https://github.com/narenlog/grails-wicket/commit/675b810fdcdcb3d0a0a77d1fcca5a2981f4fc7d0
<br>
Commit upgrading to wicket 1.5.2: https://github.com/narenlog/grails-wicket/commit/0e253fd6a9d25c5648cccab276217e884d7e77b7
<br>
SVN : http://svn.codehaus.org/grails-plugins/grails-wicket/trunk/

**IMPORTANT:**
--------------
This plugin changes the URL pattern for accessing wicket URLs from "/app" to "/"

BEFORE: http://localhost:8080/MyNiceApp/app

NOW: http://localhost:8080/MyNiceApp

Implication: This means you cannot access the "Grails Views" anymore. Wicket is the default UI with this change.

You can change this obviously by reverting this change in your copy of the grails-wicket plugin code.
Just revert the changes in this commit:
https://github.com/narenlog/grails-wicket/commit/35651c0508aa9dcee703a22d57f08c3f57eef051


