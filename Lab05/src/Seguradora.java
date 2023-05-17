/*
 * Seguradora.java
 * Ultima modificacao: 08/05/2023
 * Material usado na disciplina MC322
 * 
 * //TO-DO: refatorar um montao de coisa vish
 */

import java.time.LocalDate;
import java.util.ArrayList;

public class Seguradora {
    //TO-DO: inserir atributo String final cnpj
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

    //TO-DO: inserir metodos gerarSeguro() e cancelarSeguro()

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

    public ArrayList<Cliente> listarClientes(String tipoCliente) { //TO-DO: refatorar
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
    public boolean gerarSinistro(LocalDate data, String endereco, Veiculo veiculo, Cliente cliente){ //TO-DO: refatorar
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

    public boolean excluirSinistro(int id){ //TO-DO: refatorar
        /* Exclui um Sinistro da listaSinistros com base no seu campo "id"
         * Entrada: int id (id do sinistro)
         * Saida: true se encontrar o sinistro e false do contrário
        */
    
        for (Sinistro s : listaSinistros){
            if (s.getId() == id){
                listaSinistros.remove(s);
                return true;
            }
        }
        return false;
    }

    public boolean visualizarSinistro(String cliente){ //TO-DO: refatorar
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

    public Cliente encontrarCliente(String cliente){ 
        /* Localiza um cliente na listaClientes com base no seu cpf/cnpj
         * Entrada: String cliente (cpf ou cnpj do cliente buscado)
         * Saída: Cliente procurado (retorna null se não encontrar)
        */
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

    // outros metodos
    public ArrayList<Veiculo> listarVeiculosClientes(){ 
        /* Lista e retorna os veiculos de todos os clientes da seguradora
         * Saida: veiculosSeguradora (arraylist contendo todos os veiculos cadastrados)
        */
        ArrayList<Veiculo> veiculosSeguradora = new ArrayList<Veiculo>();
        for (Cliente c : listaClientes){
            for (Veiculo v : c.getListaVeiculos()){
                veiculosSeguradora.add(v);
            }
        }
        return veiculosSeguradora;
    }

    public boolean excluirVeiculoCliente(String placa){ 
        /* Exclui veiculo com base na placa
         * Entrada: String placa (placa do veiculo a ser excluido)
         * Saida: valor booleano (true se conseguir remover algum veículo, false do contrário)
        */
        for(Cliente c : listaClientes){
            if(c.removerVeiculo(placa)){
                return true;
            }
        }
        return false;
    }

    public int qtdSinistros(Cliente c){ //TO-DO: refatorar
        /* Conta os sinistros associados a um cliente c
         * Entrada: Cliente c (cliente cujos sinistros serão contados)
         * Saida: numero de sinistros
        */
        int n = 0;
        for(Sinistro s : listaSinistros){
            if (s.getCliente().equals(c)){
                n++;
            }
        }
        return n;
    }
    public ArrayList<Sinistro> listarSinistros(){ //TO-DO: refatorar
        /* Lista todos os sinistros da seguradora
         * Saida: listaSinistros (arraylist contendo os objetos tipo Sinistro da seguradora)
         */
        return listaSinistros;
    }
    
    public void calcularPrecoSeguroCliente(){ //TO-DO: refatorar
        /* Calcula o preco do seguro de todos os clientes cadastrados na seguradora */
        for(Cliente c : listaClientes){
            double preco = c.calculaScore() * (1 + qtdSinistros(c));
            c.setValorSeguro(preco);
        }
    }

    public double calcularReceita(){
        /* Calcula a receita da seguradora somando o preco de todos os seguros 
         * Saida: receita calculada
        */
        double receita = 0;
        for(Cliente c : listaClientes){
            receita += c.getValorSeguro();
        }
        return receita;
    }   

    public boolean transferirSeguro(String cliente1, String cliente2){ //TO-DO: refatorar
        /* Recebe o cpf/cnpj de dois clientes, troca seus veiculos e recalcula e exibe o novo valor de seguro deles.
         * Entradas: cliente1, cliente2 (cpf ou cnpj dos dois clientes)
         * Saida: true se encontrar os clientes e false do contrário
        */
        Cliente c1 = encontrarCliente(cliente1);
        Cliente c2 = encontrarCliente(cliente2);

        if(c1 == null || c2 == null){
            return false;
        }else{
            ArrayList<Veiculo> aux = new ArrayList<Veiculo>();
            aux = c1.getListaVeiculos();
            c1.setListaVeiculos(c2.getListaVeiculos());
            c2.setListaVeiculos(aux);

            calcularPrecoSeguroCliente();

            System.out.println("Transferência de seguro concluída.\nValor do seguro de "+c1.getNome()+": "+c1.getValorSeguro()+
            "\nValor do seguro de "+c2.getNome()+": "+c2.getValorSeguro());
            return true;
        }
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
