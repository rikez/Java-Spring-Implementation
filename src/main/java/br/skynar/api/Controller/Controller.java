package br.skynar.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.ModelAndView;

@org.springframework.stereotype.Controller
public abstract class Controller {
	
	@Autowired
	private ModelAndView modelAndView;
	
	protected ModelAndView getModelAndView() {
		return this.modelAndView;
	}
	
	protected RequestAttribute getParams() {
		return null;
	}
}
