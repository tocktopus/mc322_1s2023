public enum MenuOperacoes {
    CADASTRAR_CLIENTE(1),
    LISTAR(2),
    EXCLUIR(3),
    GERARSINISTRO(4),
    TRANSFERIRSEGURO(5),
    CALCRECEITA(6),
    SAIR(0);

    public final int operacao;

    MenuOperacoes(int operacao){
        this.operacao = operacao;
    }

    public int getOperacao() {
        return operacao;
    }

    
}
