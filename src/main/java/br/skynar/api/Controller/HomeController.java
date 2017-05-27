package br.skynar.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.skynar.api.Service.SprintReportsService;

@org.springframework.stereotype.Controller
@RequestMapping("/")
public class HomeController extends Controller {
	
	@Autowired
	private SprintReportsService sprintReports;
	
	@RequestMapping("/login")
	public ModelAndView index() {
		ModelAndView modelAndView = new ModelAndView("users/signup");
		return modelAndView;
	}
	
	@ResponseBody
	@RequestMapping("/reports")
	public String getSprintResults() {
		return sprintReports.getDetailedSprintResult(1, "Sprint1");
	}
	
}
