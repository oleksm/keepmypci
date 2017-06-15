package tech.oleks.keepmypci

import com.jcraft.jsch.KnownHosts

class KeepMyPci {

	def run(def conf) {
		
		if (!conf.hosts) {
			println "conf hosts is required"
			System.exit(-1)
		}
		
		if (!conf.user) {
			println "conf user is required"
			System.exit(-1)
		}
		
		if (!conf.pass) {
			println "conf pass is required"
			System.exit(-1)
		}
		
		def port = conf.port ?: 22
		
		conf.hosts.each { host ->
			try {
				def sh = new SSHClient().connect(host, port, conf.user, conf.pass)
				// re-try with alt pass
				if (!sh) {
					sh = new SSHClient().connect(host, port, conf.user, conf.alt)
				}
				if (!sh) {
					println "was unable to connect to $conf.user@$host pass and alt"
				}
			}
			catch (Exception ex) {
					println "Error connecting to $conf.user@$host"
					ex.printStackTrace()
			}
		}
		println "Done."
	}
}
