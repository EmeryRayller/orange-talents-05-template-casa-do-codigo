package me.rayll.autor;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.rayll.autor.validacoes.ValidacaoEmail;

@RestController
@RequestMapping("/casadocodigo/v1/autor")
public class AutorController {
	
	@Autowired
	private AutorRepository repository;
	
	@Autowired
	private ValidacaoEmail validacaoEmail;
	
	@InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(validacaoEmail);
	}
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.OK)
	public AutorDTO CadastroNovoAutor(@Valid @RequestBody AutorDTO form) {
		Autor autorSalvo = repository.save(new Autor(form));
		return new AutorDTO(autorSalvo);
	}
}
