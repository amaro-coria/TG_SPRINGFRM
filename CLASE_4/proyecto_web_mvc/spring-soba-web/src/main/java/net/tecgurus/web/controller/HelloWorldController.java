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

	@RequestMapping(value = "/holaMundo", method = RequestMethod.GET)
	public ModelAndView hello1(ModelAndView view) {
		log.debug("Metodo hello1");
		view.setViewName("helloworld");
		return view;
	}

	@RequestMapping(value = "/holaMundo/{name}", method = RequestMethod.GET)
	public ModelAndView hello2(@PathVariable("name") String name) {
		log.debug("Metodo hello2 para: {}", name);
		ModelAndView view = new ModelAndView();
		view.setViewName("helloworld");
		view.addObject("name", name);
		return view;
	}

	@RequestMapping(value = "/hola")
	public String hello3() {
		log.debug("Metodo hello3");
		return "helloworld";
	}

}
