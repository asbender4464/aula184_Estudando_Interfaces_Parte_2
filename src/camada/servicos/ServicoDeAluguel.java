package camada.servicos;

import camada.dominio.AluguelDeCarro;
import camada.dominio.NotaFiscal;

public class ServicoDeAluguel {

	//Atributos
	private Double precoPorHora;
	private Double precoPorDia;
	
	//Estabelecendo a associa��o com a 'Classe ServicoImposto', que � uma 'interface gen�rica'.
	private ServicoImposto servicoImposto;
	
	//Construtor com argumentos
	public ServicoDeAluguel(Double precoPorHora, Double precoPorDia, ServicoImposto servicoImposto) {
		this.precoPorHora = precoPorHora;
		this.precoPorDia = precoPorDia;
		this.servicoImposto = servicoImposto;
	}
	
	//M�todo 'processarNotaFiscal'. Aplica-se aqui a Regra de Neg�cio.
	//No Java as datas s�o apresentadas em 'milissegundos'.
	public void processarNotaFiscal(AluguelDeCarro aluguelDeCarro) {
		long t1 = aluguelDeCarro.getInicio().getTime(); //Pega a data do in�cio da loca��o e a converte em milissegundos.
		long t2 = aluguelDeCarro.getFim().getTime(); //Pega a data do fim da loca��o e a converte em milissegundos.
		
		//Calculando a diferen�a 'em horas' entre in�cio e fim da loca��o.
		double horas = (double)(t2 - t1) / 1000 / 60 / 60; //O 'casting' � pra 'garantir' que o resultado gerado seja 'double'.
		
		//Aplicando a Regra de Neg�cio para calcular o 'valor b�sico para pagamento' (antes do imposto).
		double pagamentoBasico; //� preciso declarar esta vari�vel 'fora do escopo' do IF abaixo.
		if (horas <= 12.0) { //Calcular pagamento por horas, se loca��o for menor ou igual a 12 horas.
			pagamentoBasico = Math.ceil(horas) * precoPorHora; //'Math.ceil' � para 'arredondar um n�mero para cima'.
		}
		else { //Calcular pagamento por di�rias, se loca��o for maior que 12 horas
			pagamentoBasico = Math.ceil(horas / 24) * precoPorDia; //'Math.ceil' � para 'arredondar um n�mero para cima'.
		}
		
		//Calculando o valor do imposto
		double imposto = servicoImposto.totalImposto(pagamentoBasico);
		
		//Tendo-se calculado o 'valor b�sico de pagamento' e o 'imposto', emite-se a NF, ou seja, � poss�vel a
		//instancia��o do objeto 'NotaFiscal'.
		aluguelDeCarro.setNotaFiscal(new NotaFiscal(pagamentoBasico, imposto));
	}
}
