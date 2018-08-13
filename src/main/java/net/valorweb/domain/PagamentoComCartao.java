package net.valorweb.domain;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.Setter;
import net.valorweb.domain.enums.EstadoPagamento;

@Entity
public class PagamentoComCartao  extends Pagamento{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PagamentoComCartao() {
		super();
		
	}

	public PagamentoComCartao(EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(estado, pedido);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	@Getter
	@Setter
	private Integer numeroDeParcelas;
}
