package biz.r2s.sms.server

import grails.converters.JSON;

class ServidorController {

	def servidorService
	def show() {
		render servidorService.getInformacoes() as JSON
	}

	def start(){

		def retorno
		try{
			servidorService.iniciar()
			retorno=servidorService.getStatus()
		}catch(Exception e){
			retorno =  e
		}

		render retorno as JSON
	}

	def stop(){

		def retorno
		try{
			servidorService.parar()
			retorno=servidorService.getStatus()
		}catch(Exception e){
			retorno =  e
		}

		render retorno as JSON
	}

	def status(){
		render servidorService.getStatus() as JSON
	}
}
