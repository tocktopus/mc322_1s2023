/*
 * ClientePF.java
 * Ultima modificacao: 08/05/2023
 * Material usado na disciplina MC322
 */

import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePF extends Cliente {
    private final String cpf;
    private String genero;
    private String educacao;
    private LocalDate dataNascimento;
    private ArrayList<Veiculo> listaVeiculos;

    // construtor
    public ClientePF(String nome, String cpf, String telefone, String endereco, String email, String genero, String educacao, 
            LocalDate dataNascimento) {
        super(nome, telefone, endereco, email);
        this.cpf = cpf;
        this.genero = genero;
        this.educacao = educacao;
        this.dataNascimento = dataNascimento;
        listaVeiculos = new ArrayList<Veiculo>();
    }

    @Override
    public String toString() {
        String dados = ""; 
        
        dados += "Nome: " + this.nome + "\nCPF: " + this.cpf + "\nTelefone: " + this.telefone + "\nEndereco: " + this.endereco +
                "\nEmail: " + this.email + "\nGenero: " + this.genero + "\nEducacao: " + this.educacao + "\nData nascimento: " + 
                this.dataNascimento + "\nLista Veiculos:\n" + this.listaVeiculos;

        return dados;
    }

    /**
     * Insere um Veiculo na listaVeiculos do cliente.
     * @param veiculo (Veiculo a ser inserido)
     * @return valor booleano (true se o veiculo nao estiver na lista, false do contrario)
     */
    public boolean cadastrarVeiculo(Veiculo veiculo){
        if(!listaVeiculos.contains(veiculo)){
            listaVeiculos.add(veiculo);
            return true;
        }
        return false;
    }

    /**
     * Remove um veiculo da listaVeiculos do cliente.
     * @param veiculo (Veiculo que sera removido)
     * @return valor booleano (true se a lista conter o veiculo, false do contrario)
     */
    public boolean removerVeiculo(Veiculo veiculo){
        
        if(listaVeiculos.contains(veiculo)){
            listaVeiculos.remove(veiculo);
            return true;
            
        }
        return false;
    }

    /**
     * Remove um veiculo da listaVeiculos do cliente a partir de sua placa.
     * @param placaVeiculo (placa do veiculo que sera removido)
     * @return valor booleano (true se a lista conter o veiculo, false do contrario)
     */
    public boolean removerVeiculo(String placaVeiculo){

        for(Veiculo v : listaVeiculos){
            if(v.getPlaca().equals(placaVeiculo)){
                listaVeiculos.remove(v);
                return true;
            }
        }
        return false;
    }

    /*public long idade(){
        LocalDate agora = LocalDate.now();
        return ChronoUnit.YEARS.between(dataNascimento, agora);
    }

    @Override
    public double calculaScore(){ //TO-DO: REFATORAR colocar em seguro
        //Calcula o score (pontuacao) de um cliente fisico com base em sua idade e num. de veiculos.
        //Saida: score (double com o score do cliente)
         
        double score = 0;

        // Score novo deve ser:
        //  ( VALOR_BASE * FATOR_IDADE * (1 + 1/( quantidadeVeiculos +2) ) * 
        //  (2 + quantidadeSinistrosCliente /10) * (5 + quantidadeSinistrosCondutor /10) )
        
        if (idade() >= 18 && idade() <= 30){
            score = CalcSeguro.VALOR_BASE.fator * CalcSeguro.FATOR_18_30.fator * listaVeiculos.size(); 

        }else if(idade() > 30 && idade() <= 60){
            score = CalcSeguro.VALOR_BASE.fator * CalcSeguro.FATOR_30_60.fator * listaVeiculos.size();

        }else if(idade() > 60 && idade() <=90){
            score = CalcSeguro.VALOR_BASE.fator * CalcSeguro.FATOR_60_90.fator * listaVeiculos.size(); 
        }
        return score;
    }*/

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

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    

}
