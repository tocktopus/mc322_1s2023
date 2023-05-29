/*
 * Seguradora.java
 * Ultima modificacao: 29/05/2023
 * Material usado na disciplina MC322
 * 
 * //TO-DO: refatorar um montao de coisa vish
 */

import java.util.ArrayList;

public class Seguradora {
    private final String cnpj;
    private String nome;
    private String telefone;
    private String email;
    private String endereco;
    private ArrayList<Seguro> listaSeguros; //TO-DO: inserir atributo String final cnpj e ArrayList listaSeguros; remover listaSinistros
    private ArrayList<Cliente> listaClientes;

    // construtor
    public Seguradora(String cnpj, String nome, String telefone, String email, String endereco) {
        this.cnpj = cnpj;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        listaSeguros = new ArrayList<Seguro>();
        listaClientes = new ArrayList<Cliente>();
    }

    public String toString() { //nao incluindo listaSinistros e listaClientes pois os exibiremos em metodos separados
        String dados = "";
        dados += "CNPJ: " + this.cnpj + "\nNome: " + this.nome + "\nData Licenca: " + this.telefone
                + "\nEmail: " + this.email + "\nEndereco: " + this.endereco ;

        return dados;
    }

    //TO-DO: inserir metodos gerarSeguro() e cancelarSeguro(), getSegurosPorCliente(), getSinistrosPorCliente(), e tbm listarSeguros()

    // metodos relacionados ao atributo listaClientes:
    /**
     * Lista todos os clientes da seguradora
     * @return listaClientes (ArrayList contendo os clientes)
     */
    public ArrayList<Cliente> listarClientes(){
        return listaClientes;
    }

    /**
     * Separa todos os clientes de um determinado tipo em uma lista
     * @param tipoCliente (String informando o tipo de cliente que se deseja listar)
     * @return ArrayList contendo todos os clientes correspondentes
     */
    public ArrayList<Cliente> listarClientes(String tipoCliente) {
        
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

    /**
     * Insere um cliente tipo pessoa física na listaClientes.
     * @param cliente (cliente a ser cadastrado)
     * @return valor booleano (true se o cadastro for realizado com sucesso, false se nao for)
     */
    public boolean cadastrarCliente(ClientePF cliente) {

        if (Validacao.validarCPF(cliente.getCpf()) && Validacao.validarNome(cliente.getNome()) && !listaClientes.contains(cliente)) { // verifica se o cpf é valido e se o cliente ja foi cadastrado
            listaClientes.add(cliente);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Insere um cliente tipo pessoa jurídica na listaClientes.
     * @param cliente (cliente a ser cadastrado)
     * @return valor booleano (true se o cadastro for realizado com sucesso, false se nao for)
     */
    public boolean cadastrarCliente(ClientePJ cliente) {

        if (Validacao.validarCNPJ(cliente.getCnpj()) && Validacao.validarNome(cliente.getNome()) && !listaClientes.contains(cliente)) { // verifica se o cnpj é valido e se o cliente ja foi cadastrado
            listaClientes.add(cliente);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Remove um cliente da listaClientes.
     * @param cliente (cpf ou cnpj do cliente a ser removido)
     * @return valor booleano (true se o cliente com esse cpf/cnpj for encontrado na lista (e removido), false se nao for)
     */
    public boolean removerCliente(String cliente) {

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

    /**
     * Localiza um cliente na listaClientes com base no seu cpf/cnpj
     * @param cliente (cpf ou cnpj do cliente buscado)
     * @return Cliente procurado (retorna null se não encontrar)
     */
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

    //metodos relacionados a listaSeguros
    /**
     * Recebe um seguro e insere ele na listaSeguros da seguradora
     * @param seguro (seguro a ser cadastrado)
     * @return valor booleano correspondente ao retorno do método add()
     */
    public boolean gerarSeguro(Seguro seguro){
        return listaSeguros.add(seguro);
    }

    /**
     * Remove um seguro da listaSeguros
     * @param id (id do seguro a ser cancelado)
     * @return valor booleano (true se o seguro com esse id for encontrado na lista (e removido), false se nao for)
     */
    public boolean cancelarSeguro(int id){
        for(Seguro s : listaSeguros){
            if(s.getId() == id){
                listaSeguros.remove(s);
                return true;
            }
        }
        return false;
        
    }

    /**
     * Lista todos os seguros de um determinado cliente baseado em seu cpf ou cnpj
     * @param cliente (cpf/cnpj do cliente)
     * @return arraylist contendo os seguros
     */
    public ArrayList<Seguro> getSegurosPorCliente(String cliente){
        ArrayList<Seguro> segurosCliente = new ArrayList<Seguro>();

        if(Validacao.validarCPF(cliente)){ // se a string for cpf, ou seja, um cliente tipo pessoa fisica
            for (Seguro s : listaSeguros) {
                if (s.getCliente() instanceof ClientePF) { // se o cliente relacionado ao Seguro atual for ClientePF
                    ClientePF k = (ClientePF) s.getCliente();
                    if(k.getCpf().equals(cliente)){ // compara o cpf do Seguro atual com o recebido por parametro
                        segurosCliente.add(s);
                    }
                }
            }

        }else if(Validacao.validarCNPJ(cliente)){ // se a string for cnpj, ou seja, um cliente tipo pessoa juridica
            for (Seguro s : listaSeguros) {
                if (s.getCliente() instanceof ClientePJ) { // se o cliente relacionado ao Seguro atual for ClientePJ
                    ClientePJ k = (ClientePJ) s.getCliente();
                    if(k.getCnpj().equals(cliente)){  // compara o cpf do Seguro atual com o recebido por parametro
                        segurosCliente.add(s);
                    }
                }
            }
        }
        return segurosCliente;
    }

    /**
     * Lista todos os seguros de um determinado cliente
     * @param cliente (objeto Cliente)
     * @return arraylist contendo os seguros
     */
    public ArrayList<Seguro> getSegurosPorCliente(Cliente cliente){
        ArrayList<Seguro> segurosCliente = new ArrayList<Seguro>();
        for(Seguro s : listaSeguros){
            if (s.getCliente().equals(cliente)){
                segurosCliente.add(s);
            }
        }
        return segurosCliente;
    }

    /**
     * Lista todos os sinistros de um determinado cliente
     * @param cliente (cpf/cnpj do cliente)
     * @return arraylist contendo todos os sinistros associados
     */
    public ArrayList<Sinistro> getSinistrosPorCliente(String cliente){
        ArrayList<Sinistro> sinistrosCliente = new ArrayList<Sinistro>();

        if(Validacao.validarCPF(cliente)){ // se a string for cpf, ou seja, um cliente tipo pessoa fisica
            for (Seguro s : listaSeguros) {
                if (s.getCliente() instanceof ClientePF) { // se o cliente relacionado ao Seguro atual for ClientePF
                    ClientePF k = (ClientePF) s.getCliente();
                    if(k.getCpf().equals(cliente)){ // compara o cpf do Seguro atual com o recebido por parametro
                        sinistrosCliente.addAll(s.getListaSinistros());
                    }
                }
            }

        }else if(Validacao.validarCNPJ(cliente)){ // se a string for cnpj, ou seja, um cliente tipo pessoa juridica
            for (Seguro s : listaSeguros) {
                if (s.getCliente() instanceof ClientePJ) { // se o cliente relacionado ao Seguro atual for ClientePJ
                    ClientePJ k = (ClientePJ) s.getCliente();
                    if(k.getCnpj().equals(cliente)){  // compara o cpf do Seguro atual com o recebido por parametro
                        sinistrosCliente.addAll(s.getListaSinistros());
                    }
                }
            }
        }
        return sinistrosCliente;
    }

    /**
     * Lista todos os Sinistros de um determinado cliente
     * @param cliente (objeto Cliente)
     * @return arraylist contendo os Sinistros
     */
    public ArrayList<Sinistro> getSinistrosPorCliente(Cliente cliente){
        ArrayList<Sinistro> sinistrosCliente = new ArrayList<Sinistro>();
        for(Seguro s : listaSeguros){
            if (s.getCliente().equals(cliente)){
                sinistrosCliente.addAll(s.getListaSinistros());
            }
        }
        return sinistrosCliente;
    }

    /**
     * Lista todos os seguros da seguradora
     * @return arraylist contendo os seguros
     */
    public ArrayList<Seguro> listarSeguros(){
        return listaSeguros;
    }

    public ArrayList<Sinistro> listarSinistros(){
        ArrayList<Sinistro> sinistros = new ArrayList<Sinistro>();
        for(Seguro s : listaSeguros){
            sinistros.addAll(s.getListaSinistros());
        }
        return sinistros;
    }
    /**
     * Mostra o balanco de seguros de todos os clientes da Seguradora
     */
    public void calcularReceita(){

        for(Cliente c : listaClientes){
            double receita = 0;
            String cliente;

            if(c instanceof ClientePF){
                cliente = ((ClientePF)c).getCpf();
            }else{
                cliente = ((ClientePJ)c).getCnpj();
            }
            for(Seguro s : listaSeguros){
                if (s.getCliente().equals(c)){
                    receita += s.calcularValor(); 
                }
            }
            System.out.println("Cliente: " + cliente + " ; Balanço de seguros: " + Math.round(receita*100.0)/100.0); //arredonda receita p/ duas casas
        }
    }   

    /**
     * retorna sinistros de um seguro específico da listaSeguros
     * @param id (id do seguro)
     * @return arraylist contendo os sinistros
     */
    public ArrayList<Sinistro> getSinistrosPorSeguro(int id){
        for(Seguro s : listaSeguros){
            if(s.getId() == id){
                return s.getListaSinistros();
            }
        }
        return null;
    }

    /**
     * retorna condutores de um seguro específico da listaSeguros
     * @param id (id do seguro)
     * @return arraylist contendo os condutores
     */
    public ArrayList<Condutor> getCondutoresPorSeguro(int id){
        for(Seguro s : listaSeguros){
            if(s.getId() == id){
                return s.getListaCondutores();
            }
        }
        return null;
    }

    /**
     * retorna seguro da listaSeguros com base no seu id
     * @param id (id do seguro)
     * @return seguro procurado
     */
    public Seguro getSeguroPorID(int id){
        for(Seguro s : listaSeguros){
            if(s.getId() == id){
                return s;
            }
        }
        return null;
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

    public String getCnpj() {
        return cnpj;
    }

}
