package glide.fs

/**
 * sync sources dirs to target utilizing the underlying ant
 */
class Synchronizer {

    def ant = new AntBuilder()
    def sources = []
    def target = [includeEmptyDirs: true]

    def setSources(sources) {
        this.sources = [sources].flatten()
    }

    /**
     * source = [dir:"", excludes:"", includes:""]
     * sources = [source1, source2 ....]
     * target = [dir:"", preserves: "", ]
     */
    def sync() {
        ant.sync(todir: target.dir, includeEmptyDirs: target.includeEmptyDirs) {
            sources.each { source ->
                ant.fileset(source)
            }
            ant.preserveintarget(includes: target.preserves)
        }
    }

}
