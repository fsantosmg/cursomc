package net.valorweb.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class ClienteNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;

	private String email;

	private String cpfCnpj;

	private Integer tipo;

	private String logradouro;

	private String numero;

	private String complemento;

	private String bairro;

	private String cep;

	private String telefone1;
	private String telefone2;
	private String telefone3;
	
	private List<String> telefones = new ArrayList<>();

	private Integer cidadeId;

}
