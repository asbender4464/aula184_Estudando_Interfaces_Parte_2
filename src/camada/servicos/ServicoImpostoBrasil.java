package camada.servicos;

public class ServicoImpostoBrasil {

	//Atributos: não há atributos especificados no diagrama UML.
	
	//Não havendo atributos, não há 'Contrutores' nem 'GETs e SETs',
	
	//Método 'totalImposto.
	public Double totalImposto(Double baseImposto) {
		if(baseImposto <= 100.0) {
			return baseImposto * 0.20;
		}
		else {
			return baseImposto * 0.15;
		}
	}
}
