package me.rayll.autor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


public class AutorDTO {

	@NotEmpty
	private String nome;

	@NotEmpty
	@Email
	private String email;
	
	private String instante;
	
	@NotNull @Length(max = 400)
	private String descricao; 

	public AutorDTO() {}
	
	public AutorDTO(
			@NotEmpty String nome, 
			@NotEmpty @Email String email, 
			@NotNull @Length(max = 400) String descricao) {
		
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}
	
	public AutorDTO(Autor autor) {
		this.nome = autor.getNome();
		this.email = autor.getEmail();
		this.instante = dataAmigavel(autor.getInstante());
		this.descricao = autor.getDescricao();
	}


	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getInstante() {
		return instante;
	}

	public String getDescricao() {
		return descricao;
	}
	
	private String dataAmigavel(LocalDateTime dateTime) {
		return dateTime.format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm"));
	}
}
