/*
 * Seguradora.java
 * 
 * Ultima modificacao: 03/04/2023
 * 
 * Material usado na disciplina MC322
 */
import java.util.ArrayList;

public class Seguradora {
	private String nome;
	private String telefone;
	private String email;
	private String endereco;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Cliente> listaClientes;

	//construtores
    public Seguradora(){
    }

	public Seguradora (String nome, String telefone, String email, String endereco, ArrayList<Sinistro> listaSinistros, ArrayList<Cliente> listaClientes) {
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
        listaSinistros = new ArrayList<Sinistro>();
        listaClientes = new ArrayList<Cliente>();
	}

    //TO-DO: metodos da seguradora
    
	//getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


}
