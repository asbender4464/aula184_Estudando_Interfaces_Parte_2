package camada.dominio;

import java.util.Date;

public class AluguelDeCarro {

	//Atributos
	private Date inicio;
	private Date fim;
	
	//Estabelecendo as associa��es
	private Veiculo modelo;
	private NotaFiscal notaFiscal;
	
	//Construtor padr�o.
	public AluguelDeCarro() {
	}

	//Construtor com argumentos.
	//Neste construtor 'n�o h�' o argumento 'notaFiscal' pois, de acordo com o diagrama UML,
	//a NF poder� ou n�o ter sido gerada.
	public AluguelDeCarro(Date inicio, Date fim, Veiculo modelo) {
		this.inicio = inicio;
		this.fim = fim;
		this.modelo = modelo;
	}

	//GETs e SETs
	public Date getInicio() {
		return inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public Date getFim() {
		return fim;
	}

	public void setFim(Date fim) {
		this.fim = fim;
	}

	public Veiculo getVeiculo() {
		return modelo;
	}

	public void setVeiculo(Veiculo modelo) {
		this.modelo = modelo;
	}

	public NotaFiscal getNotaFiscal() {
		return notaFiscal;
	}

	public void setNotaFiscal(NotaFiscal notaFiscal) {
		this.notaFiscal = notaFiscal;
	}
}
