package br.skynar.api.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


@Repository
@Component
public abstract class AbstractRepository {
	
	@PersistenceContext
	protected EntityManager entityManager;
	
	/*public List<AbstractEntity> findAll(AbstractEntity entity, Array fields) 
	{
		List<AbstractEntity> entity = 
				this.entityManager
				.createQuery("select e from ");
		return null;
	}*/
	
	
	
	
	
}
