/*
 * Cliente.java
 * Ultima modificacao: 21/05/2023
 * Material usado na disciplina MC322
 */

public abstract class Cliente {
    protected String nome;
    protected String telefone;
    protected String endereco;
    protected String email;

    // construtor
    public Cliente(String nome, String telefone, String endereco, String email) {
        this.nome = nome;
        this.telefone = telefone;
        this.endereco = endereco;
        this.email = email;
    }
    
    
    public String toString() {
        String dados = "";
        dados += "Nome: " + this.nome + "\nTelefone: " + this.telefone + "\nEndereco: " + this.endereco
                + "\nEmail:\n"+ this.email+"\n";

        return dados;
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

    

    
}
