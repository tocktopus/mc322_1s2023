/*
 * Cliente.java
 * 
 * Ultima modificacao: 04/04/2023
 * 
 * Material usado na disciplina MC322
 * 
 */


import java.time.LocalDate;
import java.util.ArrayList;

public class Cliente {
    protected String nome;
    protected String endereco;
    protected LocalDate dataLicenca;
    protected String educacao;
    protected String genero;
    protected String classeEconomica;
    protected ArrayList<Veiculo> listaVeiculos;

    // construtores
    public Cliente() {
    }

    public Cliente(String nome, String endereco, LocalDate dataLicenca, String educacao, String genero,
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

    public boolean addVeiculo(Veiculo veiculo){
        /* Insere um Veiculo na listaVeiculos do cliente.
         * Entrada: Veiculo a ser inserido
         * Saida: valor booleano (true se o veiculo nao estiver na lista, false do contrario)
         */
        if(!listaVeiculos.contains(veiculo)){
            listaVeiculos.add(veiculo);
            return true;
        }
        return false;
    }

    public boolean removerVeiculo(Veiculo veiculo){
        /* Remove um veiculo da listaVeiculos do cliente.
         * Entrada: Veiculo que sera removido
         * Saida: valor booleano (true se a lista conter o veiculo, false do contrario)
         */
        if(listaVeiculos.contains(veiculo)){
            listaVeiculos.remove(veiculo);
            return true;
            
        }
        return false;
    }

    public boolean removerVeiculo(String placaVeiculo){
        /* Remove um veiculo da listaVeiculos do cliente a partir de sua placa.
         * Entrada: String contendo a placa do veiculo que sera removido
         * Saida: valor booleano (true se encontrar um veiculo com essa placa, false do contrario)
         */
        for(Veiculo v : listaVeiculos){
            if(v.getPlaca().equals(placaVeiculo)){
                listaVeiculos.remove(v);
                return true;
            }
        }
        return false;
    }

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

    public LocalDate getDataLicenca() {
        return dataLicenca;
    }

    public void setDataLicenca(LocalDate dataLicenca) {
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
