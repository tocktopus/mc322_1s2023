/*
 * SeguroPJ.java
 * Ultima modificacao: 21/05/2023
 * Material usado na disciplina MC322
 */

import java.time.LocalDate;

public class SeguroPJ extends Seguro{
    private Frota frota;
    private ClientePJ cliente;

    public SeguroPJ(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, Frota frota, ClientePJ cliente) {
        super(dataInicio, dataFim, seguradora);
        this.frota = frota;
        this.cliente = cliente;
        calcularValor();
    }

    @Override
    public String toString(){
        String dados = "";
        
        dados += "ID:" + id + "\nData de Inicio: " + dataInicio + "\nData de Fim: " + dataFim + "\nSeguradora: " + seguradora 
        + "\nValor do Seguro: " + valorMensal +  "\nDados da Frota:\n" + frota + "Dados do Cliente:\n" + cliente;

        return dados;
    }

    /**
     * Calcula o valor do SeguroPJ, atualiza o atributo valorMensal e retorna o valor calculado
     * @return valor mensal calculado
     */
    @Override
    public double calcularValor(){
        double valor = 0;
        valor = CalcSeguro.VALOR_BASE.fator * (10.0 + cliente.getQtdFuncionarios()/10.0);
        valor *= (1.0 + 1.0/(frota.getListaVeiculos().size() + 2.0)) * (1.0 + 1.0/(cliente.AnosPosFundacao() + 2.0));
        valor *= (2.0 + seguradora.getSinistrosPorCliente(cliente.getCnpj()).size()/10.0);
        valor *= (5.0 + qtdSinistrosCondutores() / 10.0);
        valor = Math.round(valor*100.0)/100.0;
        this.valorMensal = valor;
        return valor;
    }

    //getters e setters
    public Frota getFrota() {
        return frota;
    }


    public void setFrota(Frota frota) {
        this.frota = frota;
    }


    public ClientePJ getCliente() {
        return cliente;
    }


    public void setCliente(ClientePJ cliente) {
        this.cliente = cliente;
    }

    
    
}
