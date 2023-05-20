/*
 * Cliente.java
 * Ultima modificacao: 08/05/2023
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


    /*public boolean addVeiculo(Veiculo veiculo){ //TO-DO: refatorar (tirar isso daqui e colocar na classe Frota)
        //Insere um Veiculo na listaVeiculos do cliente.
        //Entrada: Veiculo a ser inserido
        //Saida: valor booleano (true se o veiculo nao estiver na lista, false do contrario)
         
        if(!listaVeiculos.contains(veiculo)){
            listaVeiculos.add(veiculo);
            return true;
        }
        return false;
    }*/

    /*public boolean removerVeiculo(Veiculo veiculo){ //TO-DO: refatorar (tirar isso daqui e colocar na classe Frota)
        //Remove um veiculo da listaVeiculos do cliente.
        //Entrada: Veiculo que sera removido
        //Saida: valor booleano (true se a lista conter o veiculo, false do contrario)
        
        if(listaVeiculos.contains(veiculo)){
            listaVeiculos.remove(veiculo);
            return true;
            
        }
        return false;
    }*/

    /*public boolean removerVeiculo(String placaVeiculo){ //TO-DO: refatorar (tirar isso daqui e colocar na classe Frota)
        //Remove um veiculo da listaVeiculos do cliente a partir de sua placa.
        //Entrada: String contendo a placa do veiculo que sera removido
        //Saida: valor booleano (true se encontrar um veiculo com essa placa, false do contrario)
        
        for(Veiculo v : listaVeiculos){
            if(v.getPlaca().equals(placaVeiculo)){
                listaVeiculos.remove(v);
                return true;
            }
        }
        return false;
    }*/

    //public abstract double calculaScore();
    
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
