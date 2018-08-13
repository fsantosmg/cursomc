package net.valorweb.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Pedido implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Getter
	@Setter
	private Integer id;
	

	@NonNull
	@Getter
	@Setter
	private Date instante;
	

	@Getter
	@Setter
	@OneToOne(cascade=CascadeType.ALL, mappedBy="pedido")
	private Pagamento pagamento;
	
	@NonNull
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente cliente;
	
	@NonNull
	@Getter
	@Setter
	@ManyToOne
	@JoinColumn(name="endereco_de_entrega_id")
	private Endereco enderecoDeEntrega;

}
