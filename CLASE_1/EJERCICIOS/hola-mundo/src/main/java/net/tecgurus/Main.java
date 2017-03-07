package net.tecgurus;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.tecgurus.hola.Saludo;
import net.tecgurus.service.Cliente;

public class Main {

	public static void main(String[] args) {
		System.out.println("HolaMundo!");
		ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		Saludo bean = ctx.getBean("saludo1", Saludo.class);
		System.out.println(bean.saluda());
		System.out.println("#############INICIO DEL PROGRAMA############");
		Cliente cliente1 = ctx.getBean(Cliente.class);
		System.out.println("Evaluacion del cliente: " + cliente1.evaluaRequerimiento());
	}

}
