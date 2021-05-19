package me.rayll.livros;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/casadocodigo/v1/livro")
public class LivroController {

	@PersistenceContext
	private EntityManager manager;
	
	@PostMapping
	@Transactional
	public LivroDTO CadastroNovoLivro(@RequestBody @Valid LivroDTO form) {
		Livro livro = form.toModel(manager);
		manager.persist(livro);
		return livro.toDto();
	}
	
}
