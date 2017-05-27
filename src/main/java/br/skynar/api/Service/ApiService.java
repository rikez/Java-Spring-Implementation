package br.skynar.api.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Component
@Service
public abstract class ApiService {
	
	private String urlBase;
	
	private String endPoint;
	
	private String token;
	
	@Autowired
	protected RestTemplate restTemplate;
	
	@Autowired
	public ApiService(ParametersService parametersService) {
		this.urlBase = parametersService.getParam("urlBase").getValue();
		this.token = parametersService.getParam("token").getValue();
	}
		public void setEndPoint(String endPoint) {
		this.endPoint = endPoint;
	}

	public String getUrlBase() {
		return this.urlBase;
	}

	public String getEndPoint() {
		return this.endPoint;
	}
	
	public String getToken() {
		return token;
	}
	
	
	
	
	
	

}
