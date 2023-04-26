/*
 * Cliente.java
 * 
 * Ultima modificacao: 25/04/2023
 * 
 * Material usado na disciplina MC322
 * 
 */

import java.util.ArrayList;

public class Cliente {
    protected String nome;
    protected String endereco;
    protected ArrayList<Veiculo> listaVeiculos;

    // construtor
    public Cliente(String nome, String endereco) {
        this.nome = nome;
        this.endereco = endereco;
        listaVeiculos = new ArrayList<Veiculo>();
    }
    
    
    public String toString() {
        String dados = "";
        dados += "Nome: " + this.nome + "\nEndereco: " + this.endereco
                + "\nLista Veiculos:\n"+ this.listaVeiculos+"\n";

        return dados;
    }

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

    public double calculaScore(){
        //TO-DO: entender oq isso aqui precisa retornar
        return 0;
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

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }
}
