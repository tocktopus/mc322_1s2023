/*
 * ClientePF.java
 * Ultima modificacao: 08/05/2023
 * Material usado na disciplina MC322
 */

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ClientePF extends Cliente {
    private final String cpf;
    private LocalDate dataNascimento;
    private String educacao;
    private String genero;
    protected LocalDate dataLicenca;
    private String classeEconomica;

    // construtor
    public ClientePF(String nome, String endereco, LocalDate dataLicenca, String educacao, String genero,
            String classeEconomica, String cpf, LocalDate dataNascimento) {
        // chama o construtor da superclasse
        super(nome, endereco);
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.educacao = educacao;
        this.genero = genero;
        this.dataLicenca = dataLicenca;
        this.classeEconomica = classeEconomica;
    }

    @Override
    public String toString() {
        String dados = "";
        dados += "Nome: " + this.nome + "\nEndereco: " + this.endereco + "\nData Licenca: " + this.dataLicenca
                + "\nEducacao: " + this.educacao +
                "\nGenero: " + this.genero + "\nClasse Economica: " + this.classeEconomica + "\nCPF: " + this.cpf
                + "\nData nascimento: " + this.dataNascimento + "\nValor seguro: "+this.valorSeguro+
                "\nLista Veiculos:\n" + this.listaVeiculos;
                

        return dados;
    }


    public long idade(){
        LocalDate agora = LocalDate.now();
        return ChronoUnit.YEARS.between(dataNascimento, agora);
    }

    @Override
    public double calculaScore(){
        /* Calcula o score (pontuacao) de um cliente fisico com base em sua idade e num. de veiculos.
         * Saida: score (double com o score do cliente)
         */
        double score = 0;

        //System.out.println(CalcSeguro.FATOR_18_30.fator);
        if (idade() >= 18 && idade() <= 30){
            score = CalcSeguro.VALOR_BASE.fator * CalcSeguro.FATOR_18_30.fator * listaVeiculos.size(); 

        }else if(idade() > 30 && idade() <= 60){
            score = CalcSeguro.VALOR_BASE.fator * CalcSeguro.FATOR_30_60.fator * listaVeiculos.size();

        }else if(idade() > 60 && idade() <=90){
            score = CalcSeguro.VALOR_BASE.fator * CalcSeguro.FATOR_60_90.fator * listaVeiculos.size(); 
        }
        return score;
    }

    // getters e setters:
    public String getCpf() {
        return cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getEducacao() {
        return educacao;
    }

    public void setEducacao(String educacao) {
        this.educacao = educacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public LocalDate getDataLicenca() {
        return dataLicenca;
    }

    public void setDataLicenca(LocalDate dataLicenca) {
        this.dataLicenca = dataLicenca;
    }

    public String getClasseEconomica() {
        return classeEconomica;
    }

    public void setClasseEconomica(String classeEconomica) {
        this.classeEconomica = classeEconomica;
    }

}
