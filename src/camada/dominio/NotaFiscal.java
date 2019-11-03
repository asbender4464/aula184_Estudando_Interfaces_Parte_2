package camada.dominio;

public class NotaFiscal {

	//Atributos
	private Double pagamentoBasico;
	private Double imposto;
	
	//Construtor padr�o
	public NotaFiscal() {
	}

	//Construtor com argumentos
	public NotaFiscal(Double pagamentoBasico, Double imposto) {
		this.pagamentoBasico = pagamentoBasico;
		this.imposto = imposto;
	}

	//GETs e SETs
	public Double getPagamentoBasico() {
		return pagamentoBasico;
	}

	public void setPagamentoBasico(Double pagamentoBasico) {
		this.pagamentoBasico = pagamentoBasico;
	}

	public Double getImposto() {
		return imposto;
	}

	public void setImposto(Double imposto) {
		this.imposto = imposto;
	}
	
	//M�todo 'pagamentoTotal'.
	public double pagamentoTotal() {
		return getPagamentoBasico() + getImposto();
	}
}
