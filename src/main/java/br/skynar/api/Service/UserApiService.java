package br.skynar.api.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;

import br.skynar.api.Entity.User;

@Component
@Service
public class UserApiService extends ApiService {

	@Autowired
	public UserApiService(ParametersService parametersService) {
		super(parametersService);
	}
	
	public String createUserInService(User user) {
		this.setEndPoint("hypnobox/user");
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.add("name", user.getName());
		map.add("email", user.getEmail());
		//map.add("dob", user.getDob());
		String result = null;
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
