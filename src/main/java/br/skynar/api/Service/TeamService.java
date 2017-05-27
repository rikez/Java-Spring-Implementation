package br.skynar.api.Service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.skynar.api.Entity.Team;
import br.skynar.api.Repository.TeamRepository;

@Service
@Component
public class TeamService extends AbstractService {
	
	@Autowired
	private TeamRepository teamRepository;
	
	
	public List<Team> findAll() {
		return this.teamRepository.find();
	}

}
