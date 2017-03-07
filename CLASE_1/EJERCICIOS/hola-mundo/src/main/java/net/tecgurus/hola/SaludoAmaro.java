package net.tecgurus.hola;

import org.springframework.stereotype.Component;

@Component(value = "saludo1")
public class SaludoAmaro implements Saludo {

	public String saluda() {
		return "Hola mundo -- Jorge Amaro";
	}

}
