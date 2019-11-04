package camada.servicos;

import camada.dominio.AluguelDeCarro;
import camada.dominio.NotaFiscal;

public class ServicoDeAluguel {

	//Atributos
	private Double precoPorHora;
	private Double precoPorDia;
	
	//Estabelecendo a associação com a 'Classe ServicoImposto', que é uma 'interface genérica'.
	private ServicoImposto servicoImposto;
	
	//Construtor com argumentos
	public ServicoDeAluguel(Double precoPorHora, Double precoPorDia, ServicoImposto servicoImposto) {
		this.precoPorHora = precoPorHora;
		this.precoPorDia = precoPorDia;
		this.servicoImposto = servicoImposto;
	}
	
	//Método 'processarNotaFiscal'. Aplica-se aqui a Regra de Negócio.
	//No Java as datas são apresentadas em 'milissegundos'.
	public void processarNotaFiscal(AluguelDeCarro aluguelDeCarro) {
		long t1 = aluguelDeCarro.getInicio().getTime(); //Pega a data do início da locação e a converte em milissegundos.
		long t2 = aluguelDeCarro.getFim().getTime(); //Pega a data do fim da locação e a converte em milissegundos.
		
		//Calculando a diferença 'em horas' entre início e fim da locação.
		double horas = (double)(t2 - t1) / 1000 / 60 / 60; //O 'casting' é pra 'garantir' que o resultado gerado seja 'double'.
		
		//Aplicando a Regra de Negócio para calcular o 'valor básico para pagamento' (antes do imposto).
		double pagamentoBasico; //É preciso declarar esta variável 'fora do escopo' do IF abaixo.
		if (horas <= 12.0) { //Calcular pagamento por horas, se locação for menor ou igual a 12 horas.
			pagamentoBasico = Math.ceil(horas) * precoPorHora; //'Math.ceil' é para 'arredondar um número para cima'.
		}
		else { //Calcular pagamento por diárias, se locação for maior que 12 horas
			pagamentoBasico = Math.ceil(horas / 24) * precoPorDia; //'Math.ceil' é para 'arredondar um número para cima'.
		}
		
		//Calculando o valor do imposto
		double imposto = servicoImposto.totalImposto(pagamentoBasico);
		
		//Tendo-se calculado o 'valor básico de pagamento' e o 'imposto', emite-se a NF, ou seja, é possível a
		//instanciação do objeto 'NotaFiscal'.
		aluguelDeCarro.setNotaFiscal(new NotaFiscal(pagamentoBasico, imposto));
	}
}
