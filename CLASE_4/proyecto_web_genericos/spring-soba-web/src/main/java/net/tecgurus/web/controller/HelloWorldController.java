package net.tecgurus.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloWorldController {

	private static final Logger log = LoggerFactory.getLogger(HelloWorldController.class);

	@RequestMapping(value = "/")
	public String test() {
		return "pages/welcome";
	}
	
	@RequestMapping(value = "/welcome")
	public String welcome() {
		return "pages/welcome";
	}

	@RequestMapping(value = "/holaMundo", method = RequestMethod.GET)
	public ModelAndView hello1(ModelAndView view) {
		log.debug("Metodo hello1");
		view.addObject("name", "Jorge Amaro");
		view.setViewName("helloworld");
		return view;
	}

	@RequestMapping(value = "/holaMundo/{name}")
	public ModelAndView hola2(@PathVariable(value = "name") String nombre) {
		ModelAndView v = new ModelAndView();
		log.debug("Este es el que invoca: {}", nombre);
		v.addObject("name", nombre);
		v.setViewName("helloworld");
		return v;
	}

	@RequestMapping(value = "/alta/{dscCorta}/{dscCompleta}/{idEstatus}")
	public ModelAndView metodoMapa(@PathVariable(value = "dscCorta") String dscCorta,
			@PathVariable(value = "dscCompleta") String dscComp, @PathVariable(value = "idEstatus") Integer idEstatus) {
		ModelAndView v = new ModelAndView();

		log.debug("Desc Corta {}", dscCorta);
		log.debug("Desc Completa {}", dscComp);
		log.debug("ID estatus: {}", idEstatus);

		v.setViewName("helloworld");
		return v;
	}

}
