package br.skynar.api.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.skynar.api.Entity.Team;
import br.skynar.api.Service.TeamService;

@RequestMapping("/dashboard/teams")
@org.springframework.stereotype.Controller
public class TeamController extends Controller {
	
	@Autowired
	private TeamService teamService;
	
	@RequestMapping(method=RequestMethod.GET)
	@Cacheable(value="teamList")
	public ModelAndView index() {	
		
		List<Team> teams 		= teamService.findAll();
		ModelAndView modelView 		= this.getModelAndView();
			
		modelView.setViewName("teams/list");
		modelView.addObject("teams", teams);
		
		return modelView;	
	}

}
