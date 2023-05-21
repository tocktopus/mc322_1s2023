/*
 * Condutor.java
 * Ultima modificacao: 21/05/2023
 * Material usado na disciplina MC322
 */

import java.time.LocalDate;
import java.util.ArrayList;

public class Condutor {
    private final String cpf;
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    private LocalDate dataNasc;
    private ArrayList<Sinistro> listaSinistros;

    //construtor
    public Condutor(String cpf, String nome, String telefone, String endereco, String email, LocalDate dataNasc) {
        this.cpf = cpf;
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
        this.dataNasc = dataNasc;
        listaSinistros = new ArrayList<Sinistro>();
    }

    public String toString(){
        String dados = "";
        dados += "CPF:" + cpf + "\nNome: " + nome + "\nTelefone: " + telefone + "\nEndereco: " + endereco + "\nEmail: " + email
                + "\nDataNascimento: " + dataNasc + "\n"; //nao inclui a listaSinistros pra nao entrar em loop infinito
        return dados;
    }
    /**
     * Adiciona um sinistro na listaSinistros do condutor
     * @param sinistro (sinistro a ser adicionado)
     * @return boolean correspondente ao retorno do metodo add()
     */
    public boolean adicionarSinistro(Sinistro sinistro){
        return listaSinistros.add(sinistro);
    }

    //getters e setters
    public String getCpf() {
        return cpf;
    }

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

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(LocalDate dataNasc) {
        this.dataNasc = dataNasc;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    

    

}
