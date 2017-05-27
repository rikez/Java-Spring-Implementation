package br.skynar.api.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import br.skynar.api.Service.SprintReportsService;

@RequestMapping("/dashboard/reports")
@org.springframework.stereotype.Controller
public class ReportController extends Controller {
	
	@Autowired
	private SprintReportsService sprintReportsService;
	
	@ResponseBody
	@RequestMapping(value="/{teamId}", method=RequestMethod.GET)
	public String index(@PathVariable String teamId) throws Exception {
		if(teamId == null) {
			throw new Exception("Invalido");
		}
		return this.sprintReportsService.getAllSprintsResult(teamId);
	}
	
	@RequestMapping("/")
	public String getSprintPage() {
		return "reports/sprint-report";
	}

}
