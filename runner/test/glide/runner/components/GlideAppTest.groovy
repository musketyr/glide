package glide.runner.components

import glide.runner.components.GlideApp

class GlideAppTest extends GroovyTestCase {
    void "test glide app dir structure"() {
        def t = new GlideApp("/tmp/glide")
        t.dir.glideFile.path == "/tmp/glide/__glide.groovy"
    }

    void "test delegation to dir"() {
        def t = new GlideApp("/tmp/glide")
        t.glideFile.path == "/tmp/glide/__glide.groovy"
    }

    void "test Dir name"(){
        def t = new GlideApp("/tmp/glide")
        assert t.name == 'glide'
    }

    void "test empty config"(){
        def t = new GlideApp("/tmp/glide")
        assert t.config == GlideApp.EMPTY_CONFIG
    }

    void "test App name"(){
        def t = new GlideApp("/tmp/glide")
        assert t.appName == 'glide_0'
    }

}
