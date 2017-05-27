package br.skynar.api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import br.skynar.api.Entity.User;
import br.skynar.api.Repository.UserRepository;

@Service
@Component
public class UserService extends AbstractService implements UserDetailsService {
	
	public UserService() {
		
	}
	
	@Autowired
	private UserApiService userApiService;
		
	@Autowired
	private UserRepository userRepository;
	
	public String createUser(User user) {
		this.userRepository.create(user);
		String result = null;
		try {
			result = this.userApiService.createUserInService(user);
			return result;
		} catch(HttpClientErrorException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public List<User> findAll() {
		return this.userRepository.find();
	}
	
	public User findById(String id) {
		return this.userRepository.findOne(id);
	}

	@Override
	public User loadUserByUsername(String email) {
		return this.userRepository.findByEmail(email);
	}
	
	

}
