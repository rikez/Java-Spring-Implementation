package br.skynar.api.Repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.skynar.api.Entity.Parameter;
import br.skynar.api.Entity.Role;
import br.skynar.api.Entity.User;

@Repository
@Component
public class RoleRepository extends AbstractRepository {


	public List<Role> findAll() {
		List<Role> roles= this.entityManager
						.createQuery("select p from Role p", Role.class)
						.getResultList();
		
		return roles;
	}
	
	public void create(Role role, String email) {
		User user = this.entityManager
			.createQuery("select u from User u where u.email =: email", User.class)
			.setParameter("email", email)
			.getSingleResult();
		
		
		
	}
}
