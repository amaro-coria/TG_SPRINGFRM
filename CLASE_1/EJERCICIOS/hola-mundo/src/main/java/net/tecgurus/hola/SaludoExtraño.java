package net.tecgurus.hola;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component(value = "saludo2")
public class SaludoExtraño implements Saludo {

	public String saluda() {
		return "Hola mundo otro -- ???!!!";
	}

}
