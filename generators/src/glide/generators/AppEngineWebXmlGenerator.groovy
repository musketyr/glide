package glide.generators

class AppEngineWebXmlGenerator {

    String generate(config) {
        def writer = new StringWriter()
        def appEngineWebXml = new groovy.xml.MarkupBuilder(writer)
        final app = config.app

        appEngineWebXml.'appengine-web-app'(xmlns: "http://appengine.google.com/ns/1.0") {
            'application' app.name?:"glide-app"
            'version' app.version?:"1"
            'threadsafe' true
            'precompilation-enabled' true

            'system-properties' {
                property(name: 'file.encoding', value: "UTF-8")
                property(name: 'groovy.source.encoding', value: "UTF-8")
                property(name: 'java.util.logging.config.file', value: "WEB-INF/logging.properties")
            }

            if (app.public_root) {
                'public-root' app.public_root
            }

            if (app.resource_files) {
                'resource-files' {
                    app.resource_files.includes.each { pattern ->
                        include(path: pattern)
                    }
                    app.resource_files.excludes.each { pattern ->
                        exclude(path: pattern)
                    }
                }
            }
            if (app.static_files) {
                'static-files' {
                    app.static_files.includes.each { pattern ->
                        include(path: pattern)
                    }
                    app.static_files.excludes.each { pattern ->
                        exclude(path: pattern)
                    }
                }
            }
        }
        writer.toString()
    }
}
