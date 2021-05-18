package me.rayll.autor;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String email;

	@CreationTimestamp
	private LocalDateTime instante;
	
	private String descricao;

	public Autor(AutorDTO autorDto) {
		this.nome = autorDto.getNome();
		this.email = autorDto.getEmail();
		this.descricao = autorDto.getDescricao();
	}
	
	public Autor() {
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public LocalDateTime getInstante() {
		return instante;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
