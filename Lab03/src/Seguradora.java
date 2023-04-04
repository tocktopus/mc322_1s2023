
/*
 * Seguradora.java
 * 
 * Ultima modificacao: 03/04/2023
 * 
 * Material usado na disciplina MC322
 * 
 * TO-DO: metodos gerarSinistro, visualizarSinistro e listarSinistro
 */
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
         * Saida: valor booleano (true se o cadastro for realizado com sucesso, false se
         * nao for)
         */

        if (cliente.validarCPF(cliente.getCpf()) && !listaClientes.contains(cliente)) { // verifica se o cpf é valido e
                                                                                        // se o cliente ja foi
                                                                                        // cadastrado
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
         * Saida: valor booleano (true se o cadastro for realizado com sucesso, false se
         * nao for)
         */

        if (cliente.validarCNPJ(cliente.getCnpj()) && !listaClientes.contains(cliente)) { // verifica se o cnpj é valido
                                                                                          // e se o cliente ja foi
                                                                                          // cadastrado
            listaClientes.add(cliente);
            return true;
        } else {
            return false;
        }
    }

    public boolean removerCliente(Cliente cliente) {
        /*
         * Remove um cliente da listaClientes.
         * Entrada: Cliente cliente (cliente a ser removido)
         * Saida: valor booleano (true se o cliente for encontrado na lista, false se
         * nao for)
         */

        for (Cliente c : listaClientes) {
            if (c.equals(cliente)) {
                listaClientes.remove(c);
                return true;
            }
        }
        return false;

    }

    public ArrayList<Cliente> listarClientes(String tipoCliente) {
        /*
         * Separa todos os clientes de um determinado tipo em uma lista
         * Entrada: String tipoCliente (String informando o tipo de cliente que se
         * deseja listar)
         * Saida: ArrayList<Cliente> lista (Lista contendo todos os clientes
         * correspondentes)
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
