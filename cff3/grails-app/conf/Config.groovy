// locations to search for config files that get merged into the main config;
// config files can be ConfigSlurper scripts, Java properties files, or classes
// in the classpath in ConfigSlurper format

// grails.config.locations = [ "classpath:${appName}-config.properties",
//                             "classpath:${appName}-config.groovy",
//                             "file:${userHome}/.grails/${appName}-config.properties",
//                             "file:${userHome}/.grails/${appName}-config.groovy"]

// if (System.properties["${appName}.config.location"]) {
//    grails.config.locations << "file:" + System.properties["${appName}.config.location"]
// }

grails.project.groupId = appName // change this to alter the default package name and Maven publishing destination
grails.mime.file.extensions = true // enables the parsing of file extensions from URLs into the request format
grails.mime.use.accept.header = false
grails.mime.types = [
    all:           '*/*',
    atom:          'application/atom+xml',
    css:           'text/css',
    csv:           'text/csv',
    form:          'application/x-www-form-urlencoded',
    html:          ['text/html','application/xhtml+xml'],
    js:            'text/javascript',
    json:          ['application/json', 'text/json'],
    multipartForm: 'multipart/form-data',
    rss:           'application/rss+xml',
    text:          'text/plain',
    xml:           ['text/xml', 'application/xml']
]

// URL Mapping Cache Max Size, defaults to 5000
//grails.urlmapping.cache.maxsize = 1000

// What URL patterns should be processed by the resources plugin
grails.resources.adhoc.patterns = ['/images/*', '/css/*', '/js/*', '/plugins/*']

// The default codec used to encode data with ${}
grails.views.default.codec = "none" // none, html, base64
grails.views.gsp.encoding = "UTF-8"
grails.converters.encoding = "UTF-8"
// enable Sitemesh preprocessing of GSP pages
grails.views.gsp.sitemesh.preprocess = true
// scaffolding templates configuration
grails.scaffolding.templates.domainSuffix = 'Instance'

// Set to false to use the new Grails 1.2 JSONBuilder in the render method
grails.json.legacy.builder = false
// enabled native2ascii conversion of i18n properties files
grails.enable.native2ascii = true
// packages to include in Spring bean scanning
grails.spring.bean.packages = []
// whether to disable processing of multi part requests
grails.web.disable.multipart=false

// request parameters to mask when logging exceptions
grails.exceptionresolver.params.exclude = ['password']

// configure auto-caching of queries by default (if false you can cache individual queries with 'cache: true')
grails.hibernate.cache.queries = false

final def resolveLogsDirectory = {
  String catalinaBase = System.properties.getProperty('catalina.base')
  if (!catalinaBase) { // just in case
    final String defaultCatalina = 'D:\\progs\\apache-tomcat-7.0.40'
    println "=== WARN === catalina.base property is not defined. Using $defaultCatalina"
    catalinaBase = defaultCatalina
  }
  return "${catalinaBase}/logs"
}

environments {
  production {
    grails.logging.jul.usebridge = false

    grails.serverURL = "http://192.168.1.213:8080/${appName}"
    grails.converters.json.pretty.print = false
    grails.converters.xml.pretty.print = false
    grails.exceptionresolver.logRequestParameters = false

    def logDirectory = resolveLogsDirectory()
    log4j = {
      appenders {
        rollingFile name: "mainLog", maxFileSize: 1024, file: "${logDirectory}/cff3.log"
        rollingFile name: "stacktrace", maxFileSize: 1024, file: "${logDirectory}/cff3-stacktrace.log"
      }

      root {
        error 'mainLog'
        additivity = true
      }

      info   'grails.app.task',
          'grails.app.service',
          'grails.app.controller',
          'grails.app.domain',
          'grails.app.tagLib',
          'grails.app.filters.LogFilters'

      error stacktrace: "StackTrace"

      error  'org.codehaus.groovy.grails.web.servlet',  //  controllers
          'org.codehaus.groovy.grails.web.pages', //  GSP
          'org.codehaus.groovy.grails.web.sitemesh', //  layouts
          'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
          'org.codehaus.groovy.grails.web.mapping', // URL mapping
          'org.codehaus.groovy.grails.commons', // core / classloading
          'org.codehaus.groovy.grails.plugins', // plugins
          'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
          'org.springframework',
          'org.hibernate',
          'org.quartz',
          'org.apache',
          'net.sf',
          'org.codehaus',
          'grails.spring'

      warn   'org.mortbay.log',
          'grails.plugin',
          'org.springframework.security',
          'grails.app.jobs'


    }
  }

  development {
    grails.logging.jul.usebridge = true

    grails.serverURL = "http://localhost:8080/${appName}"
    grails.converters.json.pretty.print = true
    grails.converters.xml.pretty.print = true
    grails.exceptionresolver.logRequestParameters = true

    
    log4j = {
      appenders {
        console name:'stdout', layout:pattern(conversionPattern: '%c{2} %m%n')
      }

      root {
        debug 'stdout'
        additivity = true
      }

      error stdout : "StackTrace"

      info   'grails.spring'

      error  'org.codehaus.groovy.grails.web.servlet',  //  controllers
          'org.codehaus.groovy.grails.web.pages', //  GSP
          'org.codehaus.groovy.grails.web.sitemesh', //  layouts
          'org.codehaus.groovy.grails.web.mapping.filter', // URL mapping
          'org.codehaus.groovy.grails.web.mapping', // URL mapping
          'org.codehaus.groovy.grails.commons', // core / classloading
          'org.codehaus.groovy.grails.plugins', // plugins
          'org.codehaus.groovy.grails.orm.hibernate', // hibernate integration
          'org.springframework',
          'org.hibernate',
          'org.quartz',
          'org.apache',
          'net.sf',
          'org.codehaus'

      warn   'org.mortbay.log'

      debug  'grails.app.task',
          'grails.app.domain',
          'grails.app.controller',
          'grails.app.service',
          'org.hibernate.transaction',
          'org.hibernate.type',
          'org.springframework.security',
          'grails.spring',
          'grails.app.filters.LogFilters',
          'grails.app.jobs',
          'org.apache.cxf'
    }
  }
}

tomcat.deploy.username="manager"
tomcat.deploy.password="secret"
tomcat.deploy.url="http://127.0.0.1:8080/manager/text"
