/*
 * SeguroPF.java
 * Ultima modificacao: 21/05/2023
 * Material usado na disciplina MC322
 */

import java.time.LocalDate;

public class SeguroPF extends Seguro{
    private Veiculo veiculo;
    private ClientePF cliente;

    public SeguroPF(LocalDate dataInicio, LocalDate dataFim, Seguradora seguradora, Veiculo veiculo, ClientePF cliente) {
        super(dataInicio, dataFim, seguradora);
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.valorMensal = calcularValor();
    }

    @Override
    public String toString(){
        String dados = "";

        dados += "ID:" + id + "\nData de Inicio: " + dataInicio + "\nData de Fim: " + dataFim + "\nSeguradora:\n" + seguradora 
        + "\nDados do Veiculo:\n" + veiculo + "Dados do Cliente:\n" + cliente;

        return dados;
    }

    @Override
    public double calcularValor(){
        double valor = 0;
        // Valor deve ser:
        //  ( VALOR_BASE * FATOR_IDADE * (1 + 1/( quantidadeVeiculos +2) ) * 
        //  (2 + quantidadeSinistrosCliente /10) * (5 + quantidadeSinistrosCondutor /10) )
        if (cliente.idade() >= 18 && cliente.idade() <= 30){
            valor = CalcSeguro.VALOR_BASE.fator * CalcSeguro.FATOR_18_30.fator * (1 + 1/(cliente.qtdVeiculos()+2)) * 
                    (2 + seguradora.getSinistrosPorCliente(cliente.getCpf()).size()/10) * (5 + qtdSinistrosCondutores()/10); 

        }else if(cliente.idade() > 30 && cliente.idade() <= 60){
            valor = CalcSeguro.VALOR_BASE.fator * CalcSeguro.FATOR_30_60.fator * (1 + 1/(cliente.qtdVeiculos()+2)) * 
                    (2 + seguradora.getSinistrosPorCliente(cliente.getCpf()).size()/10) * (5 + qtdSinistrosCondutores()/10); 

        }else if(cliente.idade() > 60 && cliente.idade() <=90){
            valor = CalcSeguro.VALOR_BASE.fator * CalcSeguro.FATOR_60_90.fator * (1 + 1/(cliente.qtdVeiculos()+2)) * 
                    (2 + seguradora.getSinistrosPorCliente(cliente.getCpf()).size()/10) * (5 + qtdSinistrosCondutores()/10); 
        }
        return valor;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public ClientePF getCliente() {
        return cliente;
    }

    public void setCliente(ClientePF cliente) {
        this.cliente = cliente;
    }

    
    
}
