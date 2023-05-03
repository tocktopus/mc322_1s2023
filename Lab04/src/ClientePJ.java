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
                "\nNumero de funcionarios: " + this.qtdFuncionarios+ "\nLista Veiculos:\n" + this.listaVeiculos+"\n";

        return dados;
    }

    public static boolean validarCNPJ(String cnpj) {
        /*
         * Recebe uma string e verifica se ela corresponde a um cnpj.
         * Entrada: String cnpj (cnpj a ser validado)
         * Saida: valor booleano (true se o cnpj for valido, false se nao for)
         */

        // removendo caracteres nao numericos
        cnpj = cnpj.replaceAll("\\.", "");
        cnpj = cnpj.replaceAll("-", "");
        cnpj = cnpj.replaceAll("/", "");

        // verificando se o cnpj tem 14 digitos e se seus digitos nao sao todos iguais
        if (cnpj.length() != 14 ||
                cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
                cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
                cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
                cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
                cnpj.equals("88888888888888") || cnpj.equals("99999999999999")) {
            return false;
        }
        char digito13, digito14;
        int soma, peso, num, r, i;

        // calculando o primeiro digito verificador:
        soma = 0;
        peso = 2;
        for (i = 11; i >= 0; i--) {
            num = (int) (cnpj.charAt(i) - 48);
            soma = soma + (num * peso);
            peso++;
            if (peso == 10) {
                peso = 2;
            }
        }

        r = soma % 11;
        if ((r == 0) || (r == 1)) {
            digito13 = '0';
        } else {
            digito13 = (char) ((11 - r) + 48);
        }

        // calculando o segundo digito verificador:
        soma = 0;
        peso = 2;
        for (i = 12; i >= 0; i--) {
            num = (int) (cnpj.charAt(i) - 48);
            soma = soma + (num * peso);
            peso = peso + 1;
            if (peso == 10) {
                peso = 2;
            }

        }

        r = soma % 11;
        if ((r == 0) || (r == 1)) {
            digito14 = '0';
        } else {
            digito14 = (char) ((11 - r) + 48);
        }

        // verificando se os digitos calculados correspondem aos do cnpj:
        if ((digito13 == cnpj.charAt(12)) && (digito14 == cnpj.charAt(13))) {
            return (true);
        } else {
            return (false);
        }
    }

    @Override
    public double calculaScore(){
        /* Calcula o score (pontuacao) de um cliente juridico com base em sua qtd de funcionarios e num. de veiculos.
         * Saida: score (double com o score do cliente)
         */
        double score = super.calculaScore() * ((1+qtdFuncionarios)/100) * listaVeiculos.size();
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
