/*
 * MenuOperacoes.java
 * Ultima modificacao: 08/05/2023
 * Material usado na disciplina MC322
 * 
 */

public enum MenuOperacoes {
    CADASTRAR(1),
    LISTAR(2),
    EXCLUIR(3),
    GERAR_SEGURO(4),
    CANCELAR_SEGURO(5),
    AUTORIZAR_CONDUTOR(6),
    DESAUTORIZAR_CONDUTOR(7),
    GERAR_SINISTRO(8),
    CALC_RECEITA(9),
    SAIR(0),

    //operacoes cadastro
    CAD_CLIENTE(1.1),
    CAD_VEICULO(1.2),
    CAD_FROTA(1.3),
    CAD_SEGURADORA(1.4),
    VOLTAR_CAD(1.5),

    //operacoes listar
    LISTAR_CLIENTE(2.1),
    LISTAR_SEGURO(2.2),
    LISTAR_SINISTROS(2.3),
    LISTAR_CONDUTORES(2.4),
    LISTAR_FROTAS(2.5),
    LISTAR_VEICULOS(2.6),
    VOLTAR_LISTAR(2.7),

    //operacoes excluir
    EXCLUIR_CLIENTE(3.1),
    EXCLUIR_VEICULO(3.2),
    EXCLUIR_FROTA(3.3),
    VOLTAR_EXCLUIR(3.4),

    INVALIDO(-1);

    public final double operacao;

    MenuOperacoes(double operacao){
        this.operacao = operacao;
    }

    public double getOperacao() {
        return operacao;
    }

    public static MenuOperacoes valor(double op) {
        for (MenuOperacoes e : values()) {
            if (e.operacao == op) {
                return e;
            }
        }
        return INVALIDO;
    }

    
}
