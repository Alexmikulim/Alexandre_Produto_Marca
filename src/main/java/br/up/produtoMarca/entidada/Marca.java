package br.up.produtoMarca.entidada;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.validation.constraints.NotNull;

@Entity
public class Marca {

	@Id
	@SequenceGenerator (name = "CONTADOR_MARCA", sequenceName = "NUM_SEQ_MARCA", allocationSize = 0)
	@GeneratedValue (strategy = GenerationType.SEQUENCE, generator = "CONTADOR_MARCA")
	private Integer id;
	@NotNull
	private String nome;
	@NotNull
	private String descricao;

	public Marca() {

	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
