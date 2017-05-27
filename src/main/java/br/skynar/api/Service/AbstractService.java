package br.skynar.api.Service;

import br.skynar.api.Repository.AbstractRepository;

public abstract class AbstractService{
	
	
	public AbstractService() {
		
	}
	
	public AbstractRepository getRepository(AbstractRepository repository) {
		return repository;
	}
	
	

}
