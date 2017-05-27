package br.skynar.api.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;

import br.skynar.api.Entity.TeamList;
import br.skynar.api.Repository.TeamListRepository;

@Component
@Service
public class SprintReportsService extends ApiService {
	
	@Autowired
	private TeamListRepository teamListRepository;
	
	@Autowired
	public SprintReportsService(ParametersService parametersService) {
		super(parametersService);
	}

	public String getSprintResult() {		
		this.setEndPoint("hypnobox/reports");
		String result;
		
		try {
			result = this.restTemplate.getForObject(
					this.getUrlBase() 
					+ this.getEndPoint() + 
					"/?token=" + this.getToken(), 
					String.class);
		} catch(HttpClientErrorException error) {
			result = error.getResponseBodyAsString();
			error.printStackTrace();
		}
		
		return result;
	}
	
	public String getDetailedSprintResult(int teamId, String sprintNumber) {		
		String boardListId = this.teamListRepository.findOne(sprintNumber, teamId).getBoardListId();
		this.setEndPoint("hypnobox/reports/details/" + boardListId + "/");
		String result;
		
		try {
			result = this.restTemplate.getForObject(
					this.getUrlBase() 
					+ this.getEndPoint() + 
					"/?token=" + this.getToken(), 
					String.class);
			return result;
		} catch(HttpClientErrorException error) {
			result = error.getResponseBodyAsString();
			error.printStackTrace();
		}
		
		return result;
	}
	
	public String getAllSprintsResult(String teamId) {	
		
		List<TeamList> teamList = this.teamListRepository.findAllByTeam(Integer.parseInt(teamId));
		this.setEndPoint("hypnobox/reports/sprints/");
		String result = null;
		
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		
		String concat = "";
		for(TeamList list: teamList) {
			 concat += list.getBoardListId() + ",";
		}
			
		 map.add("arrayListId", concat);
		
		try {
			result = this.restTemplate.postForObject(
					this.getUrlBase() + 
					this.getEndPoint() +
					"/?token=" + this.getToken(), map, String.class);
			return result;
		} catch(HttpClientErrorException error) {
			error.printStackTrace();
		}
		
		return result;
	}
}
