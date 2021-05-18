package me.rayll.autor.validacoes;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import me.rayll.autor.Autor;
import me.rayll.autor.AutorDTO;
import me.rayll.autor.AutorRepository;

@Component
public class ValidacaoEmail implements Validator{
	
	@Autowired
	private AutorRepository repository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return AutorDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if(errors.hasErrors()) {
			return;
		}
		
		AutorDTO request = (AutorDTO) target;
		
		Optional<Autor> possivelAutor = repository.findByEmail(request.getEmail());
		
		if(possivelAutor.isPresent()) {
			errors.rejectValue("email",null, 
					"Já existe um autor com esse e-mail cadastrado " + request.getEmail());
		}
	}
	
	
}
