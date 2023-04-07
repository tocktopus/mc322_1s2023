import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        //TO-DO: deixar main nos conformes das instrucoes, por enquanto estamos usando apenas para testes rapidos

        ClientePJ pj1 = new ClientePJ("PJ1", "Rua B", LocalDate.parse("2007-01-08"), "04.348.764/0001-23", LocalDate.parse("2006-01-30"));
        ClientePJ pj2 = new ClientePJ("PJ2", "Rua C", LocalDate.parse("2015-12-02"), "12.445.351/0001-95", LocalDate.parse("2012-03-22"));
        ClientePF pf1 = new ClientePF("PF1", "Avenida X", LocalDate.parse("2017-05-13"), "Ensino Medio", "M", "C", "132.104.950-17", LocalDate.parse("1990-06-18"));
        ClientePF pf2 = new ClientePF("PF2", "Avenida Y", LocalDate.parse("2022-12-24"), "Ensino Superior", "F", "C", "436.370.260-58", LocalDate.parse("1980-10-07"));

        Veiculo v1 = new Veiculo("AAA1234", "Fiat", "Uno", 2020);
        Veiculo v2 = new Veiculo("BBB3750", "Chevrolet", "Onix", 2013);
        Veiculo v3 = new Veiculo("OMG5555", "Fiat", "Uno", 2004);
        Veiculo v4 = new Veiculo("YEE8888", "Fiat", "Palio", 2007);

        pj1.addVeiculo(v1);
        pj1.addVeiculo(v2);
        pf1.addVeiculo(v3);
        pf1.addVeiculo(v4);

        pf1.removerVeiculo("YEE8888");


        Seguradora seg = new Seguradora();
        seg.cadastrarCliente(pj1);
        seg.cadastrarCliente(pj2);
        seg.cadastrarCliente(pf1);
        seg.cadastrarCliente(pf2);

        seg.removerCliente("12.445.351/0001-95");

        System.out.println("geracao de sinistro "+seg.gerarSinistro(LocalDate.parse("2008-01-15"), "Rua 1",  v1, pj1));
        System.out.println("geracao de sinistro "+seg.gerarSinistro(LocalDate.parse("2017-12-08"), "Rua 2", v2, pj1));

        System.out.println("geracao de sinistro "+seg.gerarSinistro(LocalDate.parse("2019-11-19"), "Rua 3", v3, pf1));
        System.out.println("geracao de sinistro "+seg.gerarSinistro(LocalDate.parse("2020-07-20"), "Rua 4", v4, pf1));

        //System.out.println("listando clientes\n"+seg.listarClientes("pf"));
        //System.out.println("\nlistando sinistros\n"+seg.listarSinistros());
        System.out.println("visualizacao de sinistros "+seg.visualizarSinistro("132.104.950-17"));

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


