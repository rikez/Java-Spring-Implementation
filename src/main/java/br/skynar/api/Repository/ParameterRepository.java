package br.skynar.api.Repository;


import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import br.skynar.api.Entity.Parameter;

@Component
@Repository
public class ParameterRepository extends AbstractRepository {
	
	public Parameter getByName(String parameterName) {
		Parameter param = 
				this.entityManager
				.createQuery("select p from Parameter p where paramName = :paramName", Parameter.class)
				.setParameter("paramName", parameterName)
				.getSingleResult();
		
		return param;
	}

	public List<Parameter> findAll() {
		List<Parameter> params = this.entityManager
						.createQuery("select p from Parameter p", Parameter.class)
						.getResultList();
		
		
		return params;
	}
	
}
