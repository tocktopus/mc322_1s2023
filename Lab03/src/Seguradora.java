
/*
 * Seguradora.java
 * 
 * Ultima modificacao: 04/04/2023
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

    public Seguradora(String nome, String telefone, String email, String endereco, ArrayList<Sinistro> listaSinistros,
            ArrayList<Cliente> listaClientes) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        listaSinistros = new ArrayList<Sinistro>();
        listaClientes = new ArrayList<Cliente>();
    }

    // metodos relacionados ao atributo listaClientes:
    public boolean cadastrarCliente(ClientePF cliente) {
        /*
         * Insere um cliente tipo pessoa física na listaClientes.
         * Entrada: ClientePF cliente (cliente a ser cadastrado)
         * Saida: valor booleano (true se o cadastro for realizado com sucesso, false se nao for)
         */

        if (ClientePF.validarCPF(cliente.getCpf()) && !listaClientes.contains(cliente)) { // verifica se o cpf é valido e se o cliente ja foi cadastrado
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

        if (ClientePJ.validarCNPJ(cliente.getCnpj()) && !listaClientes.contains(cliente)) { // verifica se o cnpj é valido e se o cliente ja foi cadastrado
            listaClientes.add(cliente);
            return true;
        } else {
            return false;
        }
    }

    public boolean removerCliente(Cliente cliente) { //TO-DO: remover esse metodo aq
        /*
         * Remove um cliente da listaClientes.
         * Entrada: Cliente cliente (cliente a ser removido)
         * Saida: valor booleano (true se o cliente for encontrado na lista, false se nao for)
         */

        for (Cliente c : listaClientes) {
            if (c.equals(cliente)) {
                listaClientes.remove(c);
                return true;
            }
        }
        return false;

    }

    public boolean removerCliente(String cliente) {
        /*
         * Remove um cliente da listaClientes.
         * Entrada: String cliente (cpf ou cnpj do cliente a ser removido)
         * Saida: valor booleano (true se o cliente com esse cpf/cnpj for encontrado na lista (e removido), false se nao for)
         */

        if(ClientePF.validarCPF(cliente)){
            for (Cliente c : listaClientes) { 
                if (c instanceof ClientePF) {  // verifica se c eh pessoa fisica
                    ClientePF k = (ClientePF) c; // k recebe c convertido de Cliente para ClientePF
                    if (k.getCpf().equals(cliente)) {
                        listaClientes.remove(c);
                        return true;
                    }
                }
            }
        }else if(ClientePJ.validarCNPJ(cliente)){
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
         * Saida: valor booleano (correspondente ao retorno do metodo add() do arraylist)
         */
        Sinistro s = new Sinistro(data, endereco, this, veiculo, cliente);
        return listaSinistros.add(s);
    }

    public boolean visualizarSinistro(Cliente cliente){ //TO-DO: remover esse metodo aq
        /* Imprime todos os sinistros relacionados a um cliente
         * Entrada: Cliente cujos sinistros serão exibidos
         * Saida: valor booleano (true se encontrar 1 ou mais sinistros, false do contrário)
         */
        boolean flag = false;
        for (Sinistro s : listaSinistros) {
            if (s.getCliente().equals(cliente)) {
                System.out.println(s);
                flag = true;
            }
        }
        return flag;
        
    }

    public boolean visualizarSinistro(String cliente){
        /* Imprime todos os sinistros relacionados a um cliente e retorna true se encontrar sinistro relacionado a ele
         * Entrada: String cliente (cpf ou cnpj do cliente cujos sinistros serão exibidos)
         * Saida: valor booleano (true se a string corresponder a um cpf ou cnpj valido e se encontrar 1 ou mais sinistros, false do contrario)
         */

        // a flag verifica se foram encontrados sinistros para esse cliente
        boolean flag = false;
        // objetos auxiliares para verificar se a string é um cpf, cnpj, ou nenhum dos dois:

        if(ClientePF.validarCPF(cliente)){ // se a string for cpf, ou seja, um cliente tipo pessoa fisica
            for (Sinistro s : listaSinistros) {
                if (s.getCliente() instanceof ClientePF) { // se o cliente relacionado ao sinistro atual for ClientePF
                    ClientePF k = (ClientePF) s.getCliente();
                    if(k.getCpf().equals(cliente)){ // compara o cpf do sinistro atual com o recebido por parametro
                        System.out.println(s);
                        flag = true;
                    }
                }
            }

        }else if(ClientePJ.validarCNPJ(cliente)){ // se a string for cnpj, ou seja, um cliente tipo pessoa juridica
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

    public ArrayList<Sinistro> listarSinistros(){
        /* Lista todos os sinistros da seguradora
         * Saida: listaSinistros (arraylist contendo os objetos tipo Sinistro da Seguradora)
         */
        return listaSinistros;
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
