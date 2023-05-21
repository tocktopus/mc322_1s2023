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
    }

    public int calcularValor(){
        int valor = 0;
        // Valor deve ser:
        //  ( VALOR_BASE * FATOR_IDADE * (1 + 1/( quantidadeVeiculos +2) ) * 
        //  (2 + quantidadeSinistrosCliente /10) * (5 + quantidadeSinistrosCondutor /10) )
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
