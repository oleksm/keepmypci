package tech.oleks.keepmypci

import org.yaml.snakeyaml.Yaml

class Config {

	def load(def path) {
		def yaml = new Yaml();
		def conf = yaml.load(new FileInputStream(path));
		println "loaded ${path}: ${conf.size()}"
		conf
	}
}
