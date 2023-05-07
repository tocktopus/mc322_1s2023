/*
 * Seguradora.java
 * 
 * Ultima modificacao: 25/04/2023
 * 
 * Material usado na disciplina MC322
 * 
 */

import java.time.LocalDate;
import java.util.ArrayList;

public class Seguradora {
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Sinistro> listaSinistros;
    private ArrayList<Cliente> listaClientes;

    // construtores
    public Seguradora() {
        listaSinistros = new ArrayList<Sinistro>();
        listaClientes = new ArrayList<Cliente>();
    }

    public Seguradora(String nome, String telefone, String email, String endereco) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        listaSinistros = new ArrayList<Sinistro>();
        listaClientes = new ArrayList<Cliente>();
    }

    public String toString() { //nao incluindo listaSinistros e listaClientes pois os exibiremos em metodos separados
        String dados = "";
        dados += "Nome: " + this.nome + "\nData Licenca: " + this.telefone
                + "\nEmail: " + this.email + "\nEndereco: " + this.endereco ;

        return dados;
    }

    // metodos relacionados ao atributo listaClientes:
    public boolean cadastrarCliente(ClientePF cliente) {
        /*
         * Insere um cliente tipo pessoa física na listaClientes.
         * Entrada: ClientePF cliente (cliente a ser cadastrado)
         * Saida: valor booleano (true se o cadastro for realizado com sucesso, false se nao for)
         */

        if (Validacao.validarCPF(cliente.getCpf()) && Validacao.validarNome(cliente.getNome()) && !listaClientes.contains(cliente)) { // verifica se o cpf é valido e se o cliente ja foi cadastrado
            listaClientes.add(cliente);
            return true;
        } else {
            return false;
        }
    }

    public boolean cadastrarCliente(ClientePJ cliente) {
        /*
         * Insere um cliente tipo pessoa jurídica na listaClientes.
         * Entrada: ClientePJ cliente (cliente a ser cadastrado)
         * Saida: valor booleano (true se o cadastro for realizado com sucesso, false se nao for)
         */

        if (Validacao.validarCNPJ(cliente.getCnpj()) && Validacao.validarNome(cliente.getNome()) && !listaClientes.contains(cliente)) { // verifica se o cnpj é valido e se o cliente ja foi cadastrado
            listaClientes.add(cliente);
            return true;
        } else {
            return false;
        }
    }


    public boolean removerCliente(String cliente) {
        /*
         * Remove um cliente da listaClientes.
         * Entrada: String cliente (cpf ou cnpj do cliente a ser removido)
         * Saida: valor booleano (true se o cliente com esse cpf/cnpj for encontrado na lista (e removido), false se nao for)
         */

        if(Validacao.validarCPF(cliente)){
            for (Cliente c : listaClientes) { 
                if (c instanceof ClientePF) {  // verifica se c eh pessoa fisica
                    ClientePF k = (ClientePF) c; // k recebe c convertido de Cliente para ClientePF
                    if (k.getCpf().equals(cliente)) {
                        listaClientes.remove(c);
                        return true;
                    }
                }
            }
        }else if(Validacao.validarCNPJ(cliente)){
            for (Cliente c : listaClientes) {
                if (c instanceof ClientePJ) {  // verifica se c eh pessoa juridica
                    ClientePJ k = (ClientePJ) c; // k recebe c convertido de Cliente para ClientePJ
                    if (k.getCnpj().equals(cliente)) {
                        listaClientes.remove(c);
                        return true;
                    }
                }
            }
        }
        return false;

    }

    public ArrayList<Cliente> listarClientes(String tipoCliente) {
        /*
         * Separa todos os clientes de um determinado tipo em uma lista
         * Entrada: String tipoCliente (String informando o tipo de cliente que se deseja listar)
         * Saida: ArrayList<Cliente> lista (Lista contendo todos os clientes correspondentes)
         */

        ArrayList<Cliente> lista = new ArrayList<Cliente>();
        if (tipoCliente.equals("pf")) {
            for (Cliente c : listaClientes) {
                if (c instanceof ClientePF) { // verifica se o cliente na posicao atual eh do tipo pessoa fisica
                    lista.add(c);
                }
            }
        }
        if (tipoCliente.equals("pj")) {
            for (Cliente c : listaClientes) {
                if (c instanceof ClientePJ) { // verifica se o cliente na posicao atual eh do tipo pessoa juridica
                    lista.add(c);
                }
            }
        }
        return lista;
    }

    // metodos relacionados ao atributo listaSinistros
    public boolean gerarSinistro(LocalDate data, String endereco, Veiculo veiculo, Cliente cliente){
        /* Gera um Sinistro novo e o insere na lista
         * Entrada: dados do novo Sinistro
         * Saida: valor booleano (true se o cliente tiver esse veiculo, false se nao)
         */
        if(cliente.listaVeiculos.contains(veiculo)){
            Sinistro s = new Sinistro(data, endereco, this, veiculo, cliente);
            listaSinistros.add(s);
            return true;
        }
        
        return false;
    }

    public boolean excluirSinistro(int id){
        for (Sinistro s : listaSinistros){
            if (s.getId() == id){
                listaSinistros.remove(s);
                return true;
            }
        }
        return false;
    }

    public boolean visualizarSinistro(String cliente){
        /* Imprime todos os sinistros relacionados a um cliente e retorna true se encontrar sinistro relacionado a ele
         * Entrada: String cliente (cpf ou cnpj do cliente cujos sinistros serão exibidos)
         * Saida: valor booleano (true se a string corresponder a um cpf ou cnpj valido e se encontrar 1 ou mais sinistros, false do contrario)
         */

        // a flag verifica se foram encontrados sinistros para esse cliente
        boolean flag = false;

        System.out.println("Sinistros do cliente "+cliente);
        if(Validacao.validarCPF(cliente)){ // se a string for cpf, ou seja, um cliente tipo pessoa fisica
            for (Sinistro s : listaSinistros) {
                if (s.getCliente() instanceof ClientePF) { // se o cliente relacionado ao sinistro atual for ClientePF
                    ClientePF k = (ClientePF) s.getCliente();
                    if(k.getCpf().equals(cliente)){ // compara o cpf do sinistro atual com o recebido por parametro
                        System.out.println(s);
                        flag = true;
                    }
                }
            }

        }else if(Validacao.validarCNPJ(cliente)){ // se a string for cnpj, ou seja, um cliente tipo pessoa juridica
            for (Sinistro s : listaSinistros) {
                if (s.getCliente() instanceof ClientePJ) { // se o cliente relacionado ao sinistro atual for ClientePJ
                    ClientePJ k = (ClientePJ) s.getCliente();
                    if(k.getCnpj().equals(cliente)){  // compara o cpf do sinistro atual com o recebido por parametro
                        System.out.println(s);
                        flag = true;
                    }
                }
            }
        }
        return flag;
        
    }
    
    public ClientePF encontrarClientePF(String cpf){
        for (Sinistro s : listaSinistros) {
            if (s.getCliente() instanceof ClientePF) { // se o cliente relacionado ao sinistro atual for ClientePF
                ClientePF k = (ClientePF) s.getCliente();
                if(k.getCpf().equals(cpf)){ // compara o cpf do sinistro atual com o recebido por parametro
                    return k;
                }
            }
        }
        return null;
    }

    public Cliente encontrarCliente(String cliente){
        if(Validacao.validarCPF(cliente)){
            for (Cliente c : listaClientes) { 
                if (c instanceof ClientePF) {  // verifica se c eh pessoa fisica
                    ClientePF k = (ClientePF) c; // k recebe c convertido de Cliente para ClientePF
                    if (k.getCpf().equals(cliente)) {
                        return k;
                    }
                }
            }
        }else if(Validacao.validarCNPJ(cliente)){
            for (Cliente c : listaClientes) {
                if (c instanceof ClientePJ) {  // verifica se c eh pessoa juridica
                    ClientePJ k = (ClientePJ) c; // k recebe c convertido de Cliente para ClientePJ
                    if (k.getCnpj().equals(cliente)) {
                        return k;
                    }
                }
            }
        }
        return null;
    }

    public ClientePJ encontrarClientePJ(String cnpj){
        for (Sinistro s : listaSinistros) {
            if (s.getCliente() instanceof ClientePJ) { // se o cliente relacionado ao sinistro atual for ClientePJ
                ClientePJ k = (ClientePJ) s.getCliente();
                if(k.getCnpj().equals(cnpj)){  // compara o cpf do sinistro atual com o recebido por parametro
                    return k;
                }
            }
        }
        return null;
    }

    public ArrayList<Veiculo> listarVeiculosClientes(){
        ArrayList<Veiculo> veiculosSeguradora = new ArrayList<Veiculo>();
        for (Cliente c : listaClientes){
            for (Veiculo v : c.getListaVeiculos()){
                veiculosSeguradora.add(v);
            }
        }
        return veiculosSeguradora;
    }

    public boolean excluirVeiculoCliente(String placa){
        for(Cliente c : listaClientes){
            if(c.removerVeiculo(placa)){
                return true;
            }
        }
        return false;
    }

    public int qtdSinistros(Cliente c){
        int n = 0;
        for(Sinistro s : listaSinistros){
            if (s.getCliente().equals(c)){
                n++;
            }
        }
        return n;
    }
    public ArrayList<Sinistro> listarSinistros(){
        /* Lista todos os sinistros da seguradora
         * Saida: listaSinistros (arraylist contendo os objetos tipo Sinistro da Seguradora)
         */
        return listaSinistros;
    }
    
    public void calcularPrecoSeguroCliente(){
        /* calcula o preco do seguro de todos os clientes cadastrados na seguradora */
        for(Cliente c : listaClientes){
            double preco = c.calculaScore() * (1 + qtdSinistros(c));
            c.setValorSeguro(preco);
        }
    }

    public double calcularReceita(){
        /* calcula a receita da seguradora somando o preco de todos os seguros */
        double receita = 0;
        for(Cliente c : listaClientes){
            receita += c.getValorSeguro();
        }
        return receita;
    }   

    public boolean transferirSeguro(String c1, String c2){
        /* TO-DO */
        return true;
    }

    // getters e setters
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
