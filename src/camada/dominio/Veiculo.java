package camada.dominio;

public class Veiculo {

	//Atributos
	private String modelo;
	
	//Construtor padrão
	public Veiculo() {
	}

	//Construtor com argumentos
	public Veiculo(String modelo) {
		this.modelo = modelo;
	}

	//GET e SET
	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}
}
