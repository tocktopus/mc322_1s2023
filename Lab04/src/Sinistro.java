/*
 * Sinistro.java
 * Ultima modificacao: 08/05/2023
 * Material usado na disciplina MC322
 */

import java.time.LocalDate;

public class Sinistro {
    private final int id;
    private LocalDate data;
    private String endereco;
    private Seguradora seguradora;
    private Veiculo veiculo;
    private Cliente cliente;
    private static int numSinistros = 0; // conta quantos objetos da classe Sinistro ja foram criados, e eh usada para atribuir os ids

    // construtores
    public Sinistro() {
        this.id = numSinistros;
        numSinistros++;
    }

    public Sinistro(LocalDate data, String endereco, Seguradora seguradora, Veiculo veiculo, Cliente cliente) {
        this.data = data;
        this.endereco = endereco;
        this.seguradora = seguradora;
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.id = numSinistros;
        numSinistros++;
    }
    
    public String toString() {
        String dados = "";
        dados += "ID:" + id + "\nData: " + data + "\nEndereco: " + endereco + "\nDados da Seguradora:\n" + seguradora
                + "\nDados do Veiculo:\n" + veiculo + "Dados do Cliente:\n" + cliente+"\n";
        return dados;
    }

    // getters e setters
    public int getId() {
        return id;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public static int getNumSinistros() {
        return numSinistros;
    }

    public static void setNumSinistros(int numSinistros) {
        Sinistro.numSinistros = numSinistros;
    }

}
