import java.util.Date;
import java.util.List;

public class ClientePJ extends Cliente{
    private String cnpj;
    private Date dataFundacao;

    //construtor
    public ClientePJ(String nome, String endereco, Date dataLicenca, String educacao, String genero,
            String classeEconomica, List<Veiculo> listaVeiculos, String cnpj, Date dataFundacao) {
        //chama o construtor da superclasse
        super(nome, endereco, dataLicenca, educacao, genero, classeEconomica, listaVeiculos);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
    }


    @Override
    public String toString(){
        String dados = "";
		dados += "Nome: "+this.nome+"\nEndereco: "+this.endereco+"\nData Licenca: "+this.dataLicenca+"\nEducacao: "+this.educacao+
		"\nGenero: "+this.genero+"\nClasse Economica: "+this.classeEconomica+"CNPJ: "+ this.cnpj+"Data fundacao: "+this.dataFundacao;
		
		//aqui vamos adicionar a lista de veiculos na string dados mais tarde

		return dados;
    }

    //TO-DO: funcao validar cnpj

    //getters e setters:
    public String getCnpj() {
        return cnpj;
    }


    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }


    public Date getDataFundacao() {
        return dataFundacao;
    }


    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    
}
