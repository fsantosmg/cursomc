package net.valorweb.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.valorweb.services.validation.ClienteInsert;

@NoArgsConstructor
@Getter
@Setter
@ClienteInsert
public class ClienteNewDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotEmpty(message="Preenchimento obrigatório")
	@Length(min=5, max=120, message="O tamanho dece ser entre 5 e 80 caracteres")
	private String nome;

	@NotEmpty(message="Preenchimento obrigatório")
	@Email(message="E-mail invalido")
	private String email;

	@NotEmpty(message="Preenchimento obrigatório")
	private String cpfCnpj;

	@NotEmpty
	private Integer tipo;
	
	private String senha;

	@NotEmpty(message="Preenchimento obrigatório")
	private String logradouro;

	@NotEmpty(message="Preenchimento obrigatório")
	private String numero;

	private String complemento;

	private String bairro;

	@NotEmpty(message="Preenchimento obrigatório")
	private String cep;

	private String telefone1;
	private String telefone2;
	private String telefone3;
	
	@NotEmpty(message="Preenchimento obrigatório")
	private List<String> telefones = new ArrayList<>();

	private Integer cidadeId;

}
