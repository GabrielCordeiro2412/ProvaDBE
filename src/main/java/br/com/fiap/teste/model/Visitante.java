package br.com.fiap.teste.model;

import java.time.LocalDate;

import javax.persistence.*;

@Entity
public class Visitante {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private LocalDate dateNasc;
	private String cpf;
	private String rg;
	private String digRg;
	private String dateCadastro;
	private String imagePath;

	
	public Visitante() {}	
	
	public Visitante(Long id, String name, LocalDate dateNasc, String cpf, String rg, String digRg,
			String dateCadastro, String imagePath) {
		this.id = id;
		this.name = name;
		this.dateNasc = dateNasc;
		this.cpf = cpf;
		this.rg = rg;
		this.digRg = digRg;
		this.dateCadastro = dateCadastro;
		this.imagePath = imagePath;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDateNasc() {
		return dateNasc;
	}

	public void setDateNasc(LocalDate dateNasc) {
		this.dateNasc = dateNasc;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getDateCadastro() {
		return dateCadastro;
	}

	public void setDateCadastro(String dataFormatada) {
		this.dateCadastro = dataFormatada;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public String getDigRg() {
		return digRg;
	}

	public void setDigRg(String digRg) {
		this.digRg = digRg;
	}


	
}
