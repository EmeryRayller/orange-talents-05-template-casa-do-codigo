package me.rayll.categoria;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/casadocodigo/v1/categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaRepository repository;
	
	@PostMapping
	@ResponseStatus(value = HttpStatus.OK)
	public CategoriaDTO CadastroNovaCategoria(@Valid @RequestBody CategoriaDTO form) {
		Categoria categoria = repository.save(new Categoria(form.getNome()));
		return new CategoriaDTO(categoria.getNome());
	}
}
