package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import camada.dominio.AluguelDeCarro;
import camada.dominio.Veiculo;
import camada.servicos.ServicoDeAluguel;
import camada.servicos.ServicoImpostoBrasil;


public class Programa {

	public static void main(String[] args) throws ParseException {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
		
		System.out.println("Informe os dados da locação do veículo: ");
		System.out.print("Modelo do carro: ");
		String modelo = sc.nextLine();
		System.out.print("Retirada do veículo (dd/MM/yyyy HH:ss): ");
		Date inicio = sdf.parse(sc.nextLine());
		System.out.print("Devolução do veículo (dd/MM/yyyy HH:ss): ");
		Date fim = sdf.parse(sc.nextLine());
		
		//Instanciando os objetos 'AluguelDeCarro' e 'Veiculo'.
		AluguelDeCarro aluguelDeCarro = new AluguelDeCarro(inicio, fim, new Veiculo(modelo));
		
		System.out.print("Informe o preço por hora: ");
		double precoPorHora = sc.nextDouble();
		System.out.print("Informe o preço por dia: ");
		double precoPorDia = sc.nextDouble();
		
		//Instanciando o objeto 'ServicoDeAluguel'.
		ServicoDeAluguel servicoDeAluguel = new ServicoDeAluguel(precoPorHora, precoPorDia, new ServicoImpostoBrasil());
		
		//Solicitar o processamento da NF.
		servicoDeAluguel.processarNotaFiscal(aluguelDeCarro);
		
		//Imprimindo a NF
		System.out.println("Nota Fiscal: ");
		System.out.println("Pagamento básico: " + String.format("%.2f", aluguelDeCarro.getNotaFiscal().getPagamentoBasico()));
		System.out.println("Imposto: " + String.format("%.2f", aluguelDeCarro.getNotaFiscal().getImposto()));
		System.out.println("Pagamento total: " + String.format("%.2f", aluguelDeCarro.getNotaFiscal().pagamentoTotal()));
		
		sc.close();
	}
}
