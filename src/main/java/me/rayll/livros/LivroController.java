package me.rayll.livros;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	
	@GetMapping
	@Transactional
	public List<LivroDTO> buscarLivros() {

		Query query = manager.createQuery("select l from Livro l");
		List<Livro> listaLivros = query.getResultList();
		List<LivroDTO> dtos = listaLivros.stream().map(livro -> livro.toDto()).collect(Collectors.toList());
		return dtos;

	}
	
	
	
	
}
