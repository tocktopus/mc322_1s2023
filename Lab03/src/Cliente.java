/*
 * Cliente.java
 * 
 * Ultima modificacao: 04/04/2023
 * 
 * Material usado na disciplina MC322
 * 
 */

import java.util.Date;
import java.util.ArrayList;

public class Cliente {
    protected String nome;
    protected String endereco;
    protected Date dataLicenca;
    protected String educacao;
    protected String genero;
    protected String classeEconomica;
    protected ArrayList<Veiculo> listaVeiculos;

    // construtores
    public Cliente() {
    }

    public Cliente(String nome, String endereco, Date dataLicenca, String educacao, String genero,
            String classeEconomica) {
        this.nome = nome;
        this.endereco = endereco;
        this.dataLicenca = dataLicenca;
        this.educacao = educacao;
        this.genero = genero;
        this.classeEconomica = classeEconomica;
        listaVeiculos = new ArrayList<Veiculo>();
    }
    
    
    public String toString() {
        String dados = "";
        dados += "Nome: " + this.nome + "\nEndereco: " + this.endereco + "\nData Licenca: " + this.dataLicenca
                + "\nEducacao: " + this.educacao +
                "\nGenero: " + this.genero + "\nClasse Economica: " + this.classeEconomica + "\nLista Veiculos:\n"
                + this.listaVeiculos+"\n";

        return dados;
    }

    /*public String toString() {
        return "Cliente [nome=" + nome + ", endereco=" + endereco + ", dataLicenca=" + dataLicenca + ", educacao="
                + educacao + ", genero=" + genero + ", classeEconomica=" + classeEconomica + ", listaVeiculos="
                + listaVeiculos + "]";
    }*/

    // getters e setters:
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

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }
}
