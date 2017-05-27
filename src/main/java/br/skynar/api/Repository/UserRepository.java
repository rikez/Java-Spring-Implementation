package br.skynar.api.Repository;


import java.util.List;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.skynar.api.Entity.User;

@Repository
@Transactional
public class UserRepository extends AbstractRepository {
	
	public void create(User user) {
		this.entityManager.persist(user);
	}
	
	public List<User> find() {
		List<User> users = this.entityManager
				.createQuery("select u from User u", User.class)
				.getResultList();
		
		return users;
	}

	public User findOne(String id) {
		User user = this.entityManager
					.createQuery("select u from User u where u.id_user = :userId", User.class)
					.setParameter("userId", id)
					.getSingleResult();
		
		
		return user;
	}
	
	public User findByEmail(String email) {
		List<User> users = this.entityManager
					.createQuery("select u from User u where u.email = :email", User.class)
					.setParameter("email", email)
					.getResultList();
		
		if(users.isEmpty()) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		
		return users.get(0);
	}
	
	
	
}
