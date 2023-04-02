import java.util.Date;
import java.util.List;

public class Cliente {
    protected String nome;
	protected String endereco;
	protected Date dataLicenca;
	protected String educacao;
	protected String genero;
	protected String classeEconomica;
	protected List<Veiculo> listaVeiculos;
	
	//construtor
	public Cliente(String nome, String endereco, Date dataLicenca, String educacao, String genero,
			String classeEconomica, List<Veiculo> listaVeiculos) {
		this.nome = nome;
		this.endereco = endereco;
		this.dataLicenca = dataLicenca;
		this.educacao = educacao;
		this.genero = genero;
		this.classeEconomica = classeEconomica;
		this.listaVeiculos = listaVeiculos;
	}
	

	public String toString(){
		String dados = "";
		dados += "Nome: "+this.nome+"\nEndereco: "+this.endereco+"\nData Licenca: "+this.dataLicenca+"\nEducacao: "+this.educacao+
		"\nGenero: "+this.genero+"\nClasse Economica: "+this.classeEconomica;
		
		//aqui vamos adicionar a lista de veiculos na string dados mais tarde

		return dados;
	}


	//getters e setters:
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEndereco() {
		return endereco;
	}


	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}


	public Date getDataLicenca() {
		return dataLicenca;
	}


	public void setDataLicenca(Date dataLicenca) {
		this.dataLicenca = dataLicenca;
	}


	public String getEducacao() {
		return educacao;
	}


	public void setEducacao(String educacao) {
		this.educacao = educacao;
	}


	public String getGenero() {
		return genero;
	}


	public void setGenero(String genero) {
		this.genero = genero;
	}


	public String getClasseEconomica() {
		return classeEconomica;
	}


	public void setClasseEconomica(String classeEconomica) {
		this.classeEconomica = classeEconomica;
	}


	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}


	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}
}
