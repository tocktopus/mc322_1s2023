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
        this.valorMensal = calcularValor();
    }

    @Override
    public String toString(){
        String dados = "";
        
        dados += "ID:" + id + "\nData de Inicio: " + dataInicio + "\nData de Fim: " + dataFim + "\nSeguradora: " + seguradora 
        + "\nDados da Frota:\n" + frota + "Dados do Cliente:\n" + cliente;

        return dados;
    }

    @Override
    public double calcularValor(){
        double valor = 0;
        // valor deve ser:
        //( VALOR_BASE * (10 + ( quantidadeFunc ) /10) *
        //(1 + 1/( quantidadeVeiculos +2) ) *
        //(1 + 1/( AnosPosFundacao +2) ) *
        //(2 + quantidadeSinistrosCliente /10) *
        //(5 + quantidadeSinistrosCondutor /10))
        //
        //System.out.println(cliente);
        valor = CalcSeguro.VALOR_BASE.fator * (10 + cliente.getQtdFuncionarios()/10);
        valor *= (1 + 1/(cliente.qtdVeiculos() + 2)) * (1 + 1/(cliente.AnosPosFundacao() + 2));
        valor *= (2 + seguradora.getSinistrosPorCliente(cliente.getCnpj()).size()/10);
        valor *= (5 + qtdSinistrosCondutores() / 10);
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
