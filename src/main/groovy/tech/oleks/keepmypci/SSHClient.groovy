package tech.oleks.keepmypci

import com.jcabi.ssh.SSHByPassword
import com.jcabi.ssh.Shell
import com.jcraft.jsch.JSchException

class SSHClient {
	
	def tty

	def connect(def host, def port, def user, def pass) {
		try {
			println "Starting ssh session ${host} ${user}"
			def shell = new SSHByPassword(host, port, user, pass);
			tty = new Shell.Plain(shell)
			println "> ${tty.exec('pwd')}"
			println "Connected ssh ${host} ${user}"
			tty
		}
		catch(JSchException ex) {
			if (ex.message == "Auth fail")
				null
			throw ex
		}		  
	}
	
	def exec(def cmd) {
		tty.exec(cmd)
	}
}
