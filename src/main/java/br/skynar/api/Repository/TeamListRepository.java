package br.skynar.api.Repository;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.skynar.api.Entity.Team;
import br.skynar.api.Entity.TeamList;

@Component
@Repository
public class TeamListRepository extends AbstractRepository {
	
	public TeamList findOne(String sprintName, int teamId) {
		TeamList teamList = 
				this.entityManager
				.createQuery("select t from TeamList t where listName like :listName", TeamList.class)
				.setParameter("listName", "%" + sprintName + "%")
				.getSingleResult();
		return teamList;
	}
	
	public List<TeamList> findAllByTeam(Integer teamId) {
		List<TeamList> teamList = 
				this.entityManager
				.createQuery("select t from TeamList t where t.teamId.id = :teamId", TeamList.class)
				.setParameter("teamId", teamId)
				.getResultList();
			
		return teamList;
	}
}
