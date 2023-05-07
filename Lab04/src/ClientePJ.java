/*
 * ClientePJ.java
 * 
 * Ultima modificacao: 25/04/2023
 * 
 * Material usado na disciplina MC322
 * 
 */

import java.time.LocalDate;

public class ClientePJ extends Cliente {
    private final String cnpj;
    private LocalDate dataFundacao;
    private int qtdFuncionarios;

    // construtor
    public ClientePJ(String nome, String endereco, String cnpj, LocalDate dataFundacao, int qtdFuncionarios) {
        // chama o construtor da superclasse
        super(nome, endereco);
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.qtdFuncionarios = qtdFuncionarios;
    }

    @Override
    public String toString() {
        String dados = "";
        dados += "Nome: " + this.nome + "\nEndereco: " + this.endereco
                + "\nCNPJ: " + this.cnpj + "\nData fundacao: " + this.dataFundacao +
                "\nNumero de funcionarios: " + this.qtdFuncionarios+ "\nValor seguro: "+this.valorSeguro+
                "\nLista Veiculos:\n" + this.listaVeiculos+"\n";

        return dados;
    }


    @Override
    public double calculaScore(){
        /* Calcula o score (pontuacao) de um cliente juridico com base em sua qtd de funcionarios e num. de veiculos.
         * Saida: score (double com o score do cliente)
         */
        double score = CalcSeguro.VALOR_BASE.fator * (1+(qtdFuncionarios/100)) * listaVeiculos.size();
        return score;
    }

    // getters e setters:
    public String getCnpj() {
        return cnpj;
    }

    public LocalDate getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(LocalDate dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

}
