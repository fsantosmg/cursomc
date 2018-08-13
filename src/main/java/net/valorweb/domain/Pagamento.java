package net.valorweb.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import net.valorweb.domain.enums.EstadoPagamento;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)

@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public abstract class Pagamento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Pagamento(EstadoPagamento estadoPagamento, Pedido pedido) {
		super();
		this.estadoPagamento = estadoPagamento.getCod();
		this.pedido = pedido;
	}
	

	@Id
	@Getter
	@Setter
	private Integer id;

	private Integer estadoPagamento;

	@OneToOne
	@JoinColumn(name = "pedido_id")
	@MapsId
	@Getter
	@Setter
	private Pedido pedido;

	public EstadoPagamento getEstadoPagamento() {
		return EstadoPagamento.toEnum(estadoPagamento);
	}

	public void setEstadoPagamento(EstadoPagamento estadoPagamento) {
		this.estadoPagamento = estadoPagamento.getCod();
	}


}
