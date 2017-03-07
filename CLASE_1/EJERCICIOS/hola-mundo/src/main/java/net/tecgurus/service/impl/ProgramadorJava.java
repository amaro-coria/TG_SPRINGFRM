package net.tecgurus.service.impl;

import org.springframework.stereotype.Component;

import net.tecgurus.service.Programador;

@Component
public class ProgramadorJava implements Programador {

	public String programaProblema(String entrada) {
		StringBuilder sb = new StringBuilder();
		for (int i = entrada.length() - 1; i >= 0; i--) {
			sb.append(entrada.charAt(i));
		}
		System.out.println(sb.toString());
		return sb.toString();
	}

}
