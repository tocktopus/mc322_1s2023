import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        //TO-DO: deixar main nos conformes das instrucoes, por enquanto estamos usando apenas para testes rapidos

        ClientePJ pj1 = new ClientePJ("PJ1", "B", LocalDate.parse("2007-01-08"), "A", "F", "C", "04.348.764/0001-23", null);
        ClientePJ pj2 = new ClientePJ("PJ2", "B", LocalDate.parse("2015-12-02"), "A", "F", "C", "12.445.351/0001-95", null);
        ClientePF pf1 = new ClientePF("PF1", "B", LocalDate.parse("2017-05-13"), "A", "F", "C", "132.104.950-17", null);
        ClientePF pf2 = new ClientePF("PF2", "B", LocalDate.parse("2022-12-24"), "A", "F", "C", "436.370.260-58", null);

        if(ClientePJ.validarCNPJ("19733821000165")){
            System.out.println("valido");
        }else{
            System.out.println("invalido");
        }
        Veiculo v1 = new Veiculo("1234", "honda", "carro", 2000);
        Veiculo v2 = new Veiculo("5555", "motorola", "carro", 2000);

        pj1.addVeiculo(v1);
        pj1.addVeiculo(v2);
        
        Veiculo v3 = new Veiculo("8888", "motorola", "carro", 2000);
        pj1.addVeiculo(v3);
        pj1.removerVeiculo("5555");
        pj1.removerVeiculo(v1);
        //System.out.println(c.getListaVeiculos());
        
        //System.out.println(c);

        //Sinistro s = new Sinistro("30/06/2020", null, null, v3, c);

        //System.out.println(s);

        Seguradora seg = new Seguradora();
        System.out.println("cadastro "+seg.cadastrarCliente(pj1));
        System.out.println("cadastro "+seg.cadastrarCliente(pj2));
        System.out.println("cadastro "+seg.cadastrarCliente(pf1));
        System.out.println("cadastro "+seg.cadastrarCliente(pf2));

        System.out.println("remocao "+seg.removerCliente("12.445.351/0001-95"));

        System.out.println("geracao de sinistro "+seg.gerarSinistro(LocalDate.parse("2008-01-15"), "casa",  v3, pj1));
        System.out.println("geracao de sinistro "+seg.gerarSinistro(LocalDate.parse("2017-12-08"), "rua 2", v3, pj1));

        System.out.println("geracao de sinistro "+seg.gerarSinistro(LocalDate.parse("2019-11-19"), "casa", v3, pf1));
        System.out.println("geracao de sinistro "+seg.gerarSinistro(LocalDate.parse("2020-07-20"), "rua 2", v3, pf1));

        System.out.println("geracao de sinistro "+seg.gerarSinistro(LocalDate.parse("2023-01-08"), "rua 2", v3, pf2));

        //System.out.println("listando clientes\n"+seg.listarClientes("pj"));
        //System.out.println("\nlistando sinistros\n"+seg.listarSinistros());
        System.out.println("visualizacao de sinistros "+seg.visualizarSinistro("04.348.764/0001-23"));

        /*
         * primeiro, criamos a seguradora e todos os objetos necessários
         * 
         * MENU
         * 
         * TELA INICIAL:
         * "Seguradora *nome da seguradora*
         * Bem vindo! O que deseja visualizar?
         * 1. Todos os clientes
         * 2. Lista de sinistros envolvendo pessoas físicas
         * 3. Lista de sinistros envolvendo pessoas jurídicas
         * 4. Sinistros de um cliente específico
         * Digite o número correspondente ao que deseja fazer:"
         * 
         * CASO DIGITE 1, 2, 3:
         * Chamar e imprimir o conteúdo das funções correspondentes na tela
         * 
         * CASO DIGITE 4:
         * "Digite o CPF ou CNPJ do cliente cujos sinistros deseja visualizar:"
         * Chamar a funcao passando a entrada do cliente por parametro
         * 
         * e plau
         */
    }

}


