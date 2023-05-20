/*
 * ClientePJ.java
 * Ultima modificacao: 08/05/2023
 * Material usado na disciplina MC322
 */

import java.time.LocalDate;
import java.util.ArrayList;

public class ClientePJ extends Cliente {
    private final String cnpj;
    private LocalDate dataFundacao;
    private int qtdFuncionarios; 
    private ArrayList<Frota> listaFrota;//TO-DO: add ArrayList listaFrota

    // construtor
    public ClientePJ(String nome, String cnpj, String telefone, String endereco, String email, LocalDate dataFundacao, int qtdFuncionarios) {
        super(nome, telefone, endereco, email );
        this.cnpj = cnpj;
        this.dataFundacao = dataFundacao;
        this.qtdFuncionarios = qtdFuncionarios;
        listaFrota = new ArrayList<Frota>();
    }

    @Override
    public String toString() {
        String dados = "";
        dados += "Nome: " + this.nome + "\nCNPJ: " + this.cnpj + "\nTelefone: " + this.telefone + "\nEndereco: " + this.endereco +
                "Email: " + this.email + "\nData fundacao: " + this.dataFundacao + "\nNumero de funcionarios: " + this.qtdFuncionarios +
                "\nLista de Frotas:\n" + this.listaFrota+"\n";

        return dados;
    }

    /**
     * Cria uma frota vazia e a insere na listaFrotas do cliente
     * @return valor booleano correspondente ao retorno de add()
     */
    public boolean cadastrarFrota(){
        Frota frota = new Frota();
        return listaFrota.add(frota);
    }

    /**
     * Cria uma frota com uma lista de veiculos recebida e a insere na listaFrotas do cliente
     * @param veiculos (lista de veiculos da frota)
     * @return valor booleano correspondente ao retorno de add()
     */
    public boolean cadastrarFrota(ArrayList<Veiculo> veiculos){
        Frota frota = new Frota();
        frota.setListaVeiculos(veiculos);
        return listaFrota.add(frota);
    }

    /**
     * Recebe um codigo e retorna a frota de listaFrota com codigo correspondente
     * @param code (codigo da frota)
     * @return Frota com codigo correspondente
     */
    public Frota localizarFrota(String code){
        for(Frota f : listaFrota){
            if(code.equals(f.getCode())){
                return f;
            }
        }
        return null;
    }

    /**
     * Remove uma frota inteira da listaFrotas baseada em seu codigo
     * @param code (codigo da frota)
     * @return valor booleano (true se conseguir remover, false do contrário)
     */
    public boolean alterarFrota(String code){
        Frota f = localizarFrota(code);
        if(f != null){
            return listaFrota.remove(f);
        }else{
            return false;
        }
    }

    /**
     * Remove veiculo de uma frota baseado em sua placa
     * @param code (codigo da frota)
     * @param placa (placa do veiculo a ser removido)
     * @return true se conseguir remover, false do contrario
     */
    public boolean alterarFrota(String code, String placa){
        Frota f = localizarFrota(code);
        if(f != null){
            return f.removerVeiculo(placa);
        }else{
            return false;
        }
    }

    /**
     * Adiciona veiculo a uma frota
     * @param code (codigo da frota)
     * @param veiculo (veiculo a ser cadastrado na frota)
     * @return true se conseguir cadastrar veiculo, false do contrario
     */
    public boolean alterarFrota(String code, Veiculo veiculo){
        Frota f = localizarFrota(code);
        if(f != null){
            return f.cadastrarVeiculo(veiculo);
        }else{
            return false;
        }
    }

    /**
     * Retorna os veiculos de uma frota
     * @param code (codigo da frota)
     * @return ArrayList contendo os veiculos da frota
     */
    public ArrayList<Veiculo> getVeiculosPorFrota(String code){
        Frota f = localizarFrota(code);
        if(code.equals(f.getCode())){
            return f.getListaVeiculos();
        }else{
            return null;
        }
    }
    /*
    @Override
    public double calculaScore(){  //TO-DO: REFATORAR
        //Calcula o score (pontuacao) de um cliente juridico com base em sua qtd de funcionarios e num. de veiculos.
        //Saida: score (double com o score do cliente)
        

        // Score novo deve ser:
        //( VALOR_BASE * (10 + ( quantidadeFunc ) /10) *
        //(1 + 1/( quantidadeVeiculos +2) ) *
        //(1 + 1/( AnosPosFundacao +2) ) *
        //(2 + quantidadeSinistrosCliente /10) *
        //(5 + quantidadeSinistrosCondutor /10))

        double score = CalcSeguro.VALOR_BASE.fator * (1+(qtdFuncionarios/100)) * listaVeiculos.size();
        return score;
    }*/

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

    public int getQtdFuncionarios() {
        return qtdFuncionarios;
    }

    public void setQtdFuncionarios(int qtdFuncionarios) {
        this.qtdFuncionarios = qtdFuncionarios;
    }

    public ArrayList<Frota> getListaFrota() {
        return listaFrota;
    }

    public void setListaFrota(ArrayList<Frota> listaFrota) {
        this.listaFrota = listaFrota;
    }

    

}
