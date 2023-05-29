/*
 * Seguro.java
 * Ultima modificacao: 21/05/2023
 * Material usado na disciplina MC322
 */

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class Seguro {
    protected final int id;
    protected LocalDate dataInicio;
    protected LocalDate dataFim;
    protected Seguradora seguradora;
    protected ArrayList<Sinistro> listaSinistros;
    protected ArrayList<Condutor> listaCondutores;
    protected double valorMensal;
    protected static int numSeguros = 0;

    //construtor
    public Seguro(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.seguradora = seguradora;
        listaSinistros = new ArrayList<Sinistro>();
        listaCondutores = new ArrayList<Condutor>();
        id = numSeguros;
        numSeguros++;
    }

    public abstract String toString();

    /**
     * Recebe o cpf de um condutor e o remove da lista de condutores do seguro
     * @param cpf (cpf do condutor a ser desautorizado)
     * @return valor booleano (true se encontrar condutor com esse cpf, false do contrário)
     */
    public boolean desautorizarCondutor(String cpf){
        for (Condutor c : listaCondutores){
            if(c.getCpf().equals(cpf)){
                listaCondutores.remove(c);
                return true;
            }
        }
        return false;
    }

    /**
     * Insere um condutor na listaCondutores do seguro
     * @param condutor (condutor a ser inserido)
     * @return valor booleano (true se a inserção ocorrer com sucesso, false do contrario)
     */
    public boolean autorizarCondutor(Condutor condutor){
        if(Validacao.validarCPF(condutor.getCpf()) && Validacao.validarNome(condutor.getNome()) && !listaCondutores.contains(condutor)){
            listaCondutores.add(condutor);
            return true;
        }else{
            return false;
        }
        
    }

    /**
     * Insere sinistro na listaSinistros do seguro e do condutor correspondente
     * @param sinistro (sinistro a ser gerado)
     * @return boolean (true se inserir com sucesso, false do contrario)
     */
    public boolean gerarSinistro(Sinistro sinistro){
        listaSinistros.add(sinistro);
        for (Condutor c : listaCondutores){
            if(sinistro.getCondutor().equals(c)){ //se achar o condutor, insere o sinistro na lista dele tambem
                return c.adicionarSinistro(sinistro);
            }
        }
        //se nao achar condutor igual, autoriza (insere) o condutor e insere o sinistro na lista dele
        autorizarCondutor(sinistro.getCondutor());
        return sinistro.getCondutor().adicionarSinistro(sinistro);
    }

    public int qtdSinistrosCondutores(){
        int qtd = 0;
        for(Condutor c : listaCondutores){
            qtd += c.listarSinistros().size();
        }
        return qtd;
    }

    public Condutor getCondutorPorCPF(String cpf){
        for (Condutor c : listaCondutores){
            if(c.getCpf().equals(cpf)){
                return c;
            }
        }
        return null;
    }

    public abstract double calcularValor();


    //getters e setters
    public int getId() {
        return id;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Seguradora getSeguradora() {
        return seguradora;
    }

    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

    public ArrayList<Sinistro> getListaSinistros() {
        return listaSinistros;
    }

    public void setListaSinistros(ArrayList<Sinistro> listaSinistros) {
        this.listaSinistros = listaSinistros;
    }

    public ArrayList<Condutor> getListaCondutores() {
        return listaCondutores;
    }

    public void setListaCondutores(ArrayList<Condutor> listaCondutores) {
        this.listaCondutores = listaCondutores;
    }

    public double getValorMensal() {
        return valorMensal;
    }

    public void setValorMensal(double valorMensal) {
        this.valorMensal = valorMensal;
    }

    public abstract Cliente getCliente();

    public static int getNumSeguros() {
        return numSeguros;
    }

    
    
}
