package lab02;

public class Sinistro {
	private int id;
	private String data;
	private String endereco;
	private static int numSinistros = 0; //conta quantos objetos da classe Sinistro ja foram criados, e eh usada para atribuir os ids
	
	//construtor
	public Sinistro(String data, String endereco) {
		this.data = data;
		this.endereco = endereco;
		numSinistros++;
		this.id = numSinistros;
	}

	//getters e setters
	public int getId() {
		return id;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	
}
