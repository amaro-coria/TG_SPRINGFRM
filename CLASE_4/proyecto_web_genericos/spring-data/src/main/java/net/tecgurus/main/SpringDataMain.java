package net.tecgurus.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import net.tecgurus.persistence.CatalogoDAO;

public class SpringDataMain {

	public static void main(String[] args) {
		System.out.println("Init Spring Data Main Application");
		ApplicationContext appCtx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		CatalogoDAO dao = appCtx.getBean(CatalogoDAO.class);
		dao.queryTest();
		System.out.println("Spring data main class loaded");
	}

}
