package br.skynar.api.Repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.skynar.api.Entity.Team;

@Component
@Repository
public class TeamRepository extends AbstractRepository {
	
	public List<Team> find() {
		List<Team> teams = this.entityManager
				.createQuery("select t from Team t", Team.class)
				.getResultList();
		
		return teams;
	}
	
}
