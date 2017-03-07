package net.tecgurus.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import net.tecgurus.hola.Saludo;
import net.tecgurus.service.Cliente;
import net.tecgurus.service.Programador;

@Component
public class ClienteImpl_GS implements Cliente {

	@Autowired
	private Programador programador;

	@Autowired
	@Qualifier("saludo1")
	private Saludo saludo;

	/*
	 * public ClienteImpl_GS(Programador programador) { this.programador =
	 * programador; }
	 */

	public boolean evaluaRequerimiento() {
		String palabra = "TECGURUS";
		String resultado = programador.programaProblema(palabra);
		return resultado.equals("SURUGCET");
	}

}
