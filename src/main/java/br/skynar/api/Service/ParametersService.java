package br.skynar.api.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import br.skynar.api.Entity.Parameter;
import br.skynar.api.Repository.ParameterRepository;

@Service
@Component
public class ParametersService extends AbstractService {
	
	@Autowired
	private ParameterRepository parameterRepository;

	public Parameter getParam(String parameterName) {
		return this.parameterRepository.getByName(parameterName);
	}

	public List<Parameter> findAll() {
		return this.parameterRepository.findAll();
	}
}
