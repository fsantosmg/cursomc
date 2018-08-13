package net.valorweb.domain;

import java.util.Date;

import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.valorweb.domain.enums.EstadoPagamento;

@Entity
@NoArgsConstructor
public class PagamentoComBoleto extends Pagamento {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PagamentoComBoleto( EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(estado, pedido);

		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;

	}

	@Getter
	@Setter
	private Date dataVencimento;

	@Getter
	@Setter
	private Date dataPagamento;
	
	

}
