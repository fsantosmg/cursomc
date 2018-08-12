package net.valorweb.domain.enums;

public enum TipoCliente {

	PESSOAFISICA(1, "Pessoa Física"), PESSOAJURIDICA(2, "Pessoa Jurídica");

	private Integer cod;
	private String descricao;

	private TipoCliente(Integer cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public Integer getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public static TipoCliente toEnum(Integer cod) {

		if (cod == null) {
			return null;
		}

		for (TipoCliente enumTipoCli : TipoCliente.values()) {
			if (cod.equals(enumTipoCli.getCod())) {

				return enumTipoCli;

			}

		}
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
