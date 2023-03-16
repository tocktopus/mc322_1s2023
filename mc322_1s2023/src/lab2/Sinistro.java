package lab2;

public class Sinistro {
	private int id;
	private String data;
	private String endereco;
	private static int numSinistros = 0;
	
	//construtor
	public Sinistro(String data, String endereco) {
		this.data = data;
		this.endereco = endereco;
		this.id = gerarId();
	}
	
	public int gerarId() {
		/*Retorna um id unico baseado no valor da variavel estatica numSinistros, que conta
		 * quantos objetos da classe Sinistro ja foram criados.*/
		numSinistros++;
		return numSinistros;
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
