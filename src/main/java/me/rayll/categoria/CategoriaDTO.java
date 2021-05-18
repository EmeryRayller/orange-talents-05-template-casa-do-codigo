package me.rayll.categoria;

import javax.validation.constraints.NotEmpty;

import me.rayll.validacoes.valorunico.ValorUnico;

public class CategoriaDTO {
	
	@NotEmpty
	@ValorUnico(domainClass = Categoria.class, fieldName = "nome")
	private String nome;
	
	public CategoriaDTO(@NotEmpty String nome) {
		this.nome = nome;
	}
	
	public CategoriaDTO() {}
	
	public String getNome() {
		return this.nome;
	}
}
