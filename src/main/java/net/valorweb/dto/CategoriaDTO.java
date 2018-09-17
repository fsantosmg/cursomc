package net.valorweb.dto;

import java.io.Serializable;

import lombok.Data;
import net.valorweb.domain.Categoria;

@Data
public class CategoriaDTO implements Serializable {

	public CategoriaDTO() {

	}

	public CategoriaDTO(Categoria categoria) {
		id = categoria.getId();
		nome = categoria.getNome();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private String nome;

}
