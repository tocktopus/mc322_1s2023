public enum MenuOperacoes {
    CADASTRAR(1),
    LISTAR(2),
    EXCLUIR(3),
    GERAR_SINISTRO(4),
    TRANSFERIR_SEGURO(5),
    CALC_RECEITA(6),
    SAIR(0),

    CAD_CLIENTE(1.1),
    CAD_VEICULO(1.2),
    CAD_SEGURADORA(1.3),
    VOLTAR_CAD(1.4),


    LISTAR_CLIENTE(2.1),
    LISTAR_SINISTROS_SEG(2.2),
    LISTAR_SINISTROS_CLI(2.3),
    LISTAR_VEICULOS_CLI(2.4),
    LISTAR_VEICULOS_SEG(2.5),
    VOLTAR_LISTAR(2.6),


    EXCLUIR_CLIENTE(3.1),
    EXCLUIR_VEICULO(3.2),
    EXCLUIR_SINISTRO(3.3),
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
