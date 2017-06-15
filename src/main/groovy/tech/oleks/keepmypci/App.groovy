package tech.oleks.keepmypci

class App {

	def static main(def args) {
		def path = "config.yaml"
		def conf = new Config().load(path)
		if (!conf) {
			println "config is required (${path})"
			System.exit(-1)
		}
		new KeepMyPci().run(conf)
	}
}
