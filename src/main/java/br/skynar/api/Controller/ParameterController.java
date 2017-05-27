package br.skynar.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.skynar.api.Entity.Parameter;
import br.skynar.api.Service.ParametersService;

@org.springframework.stereotype.Controller
@RequestMapping("/dashboard/parameters")
public class ParameterController extends Controller {
	
	@Autowired
	private ParametersService parametersService;
	
	@RequestMapping(method=RequestMethod.GET)
	//@Cacheable(value="paramList")
	public ModelAndView index() {	
		
		List<Parameter> params 		= parametersService.findAll();
		ModelAndView modelView 		= this.getModelAndView();
			
		modelView.setViewName("parameters/list");
		modelView.addObject("params", params);
		
		return modelView;	
	}
}
