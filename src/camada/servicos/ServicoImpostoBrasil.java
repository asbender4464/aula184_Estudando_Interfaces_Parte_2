package camada.servicos;

public class ServicoImpostoBrasil {

	//Atributos: n�o h� atributos especificados no diagrama UML.
	
	//N�o havendo atributos, n�o h� 'Contrutores' nem 'GETs e SETs',
	
	//M�todo 'totalImposto.
	public Double totalImposto(Double baseImposto) {
		if(baseImposto <= 100.0) {
			return baseImposto * 0.20;
		}
		else {
			return baseImposto * 0.15;
		}
	}
}
