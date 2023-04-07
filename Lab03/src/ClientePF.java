/*
 * ClientePF.java
 * 
 * Ultima modificacao: 04/04/2023
 * 
 * Material usado na disciplina MC322
 * 
 * TO-DO: deixar cpf como final
 */

import java.time.LocalDate;

public class ClientePF extends Cliente {
    private String cpf;
    private LocalDate dataNascimento;

    // construtores
    public ClientePF() {
    }

    public ClientePF(String nome, String endereco, LocalDate dataLicenca, String educacao, String genero,
            String classeEconomica, String cpf, LocalDate dataNascimento) {
        // chama o construtor da superclasse
        super(nome, endereco, dataLicenca, educacao, genero, classeEconomica);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
    }

    @Override
    public String toString() {
        String dados = "";
        dados += "Nome: " + this.nome + "\nEndereco: " + this.endereco + "\nData Licenca: " + this.dataLicenca
                + "\nEducacao: " + this.educacao +
                "\nGenero: " + this.genero + "\nClasse Economica: " + this.classeEconomica + "\nCPF: " + this.cpf
                + "\nData nascimento: " + this.dataNascimento +
                "\nLista Veiculos:\n" + this.listaVeiculos+"\n";

        return dados;
    }

    /*@Override
    public String toString(){
        return "Cliente [nome=" + nome + ", endereco=" + endereco + ", dataLicenca=" + dataLicenca + ", educacao="
                + educacao + ", genero=" + genero + ", classeEconomica=" + classeEconomica + ", listaVeiculos="
                + listaVeiculos + ", dataNascimento="+dataNascimento+", cpf="+cpf+ "]";
    }*/

    public static boolean validarCPF(String cpf) {
        /*
         * Recebe uma string e verifica se ela corresponde a um cpf.
         * Entrada: String cpf (cpf a ser validado)
         * Saida: valor booleano (true se o cpf for valido, false se nao for)
         */

        // removendo caracteres nao numericos
        cpf = cpf.replaceAll("\\.", "");
        cpf = cpf.replaceAll("-", "");

        // verificando se o cpf tem 11 digitos e se seus digitos nao sao todos iguais
        if (cpf.length() != 11 ||
                cpf.equals("00000000000") || cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999")) {
            return false;
        }

        char digito10, digito11;
        int soma, peso, num, r, i;

        // calculando o primeiro digito verificador:
        soma = 0;
        peso = 10;
        for (i = 0; i < 9; i++) {
            num = (int) (cpf.charAt(i) - 48);
            soma = soma + (num * peso);
            peso--;
        }

        r = 11 - (soma % 11);
        if ((r == 10) || (r == 11))
            digito10 = '0';
        else
            digito10 = (char) (r + 48);

        // calculando o segundo digito verificador:
        soma = 0;
        peso = 11;
        for (i = 0; i < 10; i++) {
            num = (int) (cpf.charAt(i) - 48);
            soma = soma + (num * peso);
            peso--;
        }

        r = 11 - (soma % 11);
        if ((r == 10) || (r == 11))
            digito11 = '0';
        else
            digito11 = (char) (r + 48);

        // verificando se os digitos calculados correspondem aos do cpf:
        if ((digito10 == cpf.charAt(9)) && (digito11 == cpf.charAt(10))) {
            return (true);
        } else {
            return (false);
        }

    }

    // getters e setters:
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

}
