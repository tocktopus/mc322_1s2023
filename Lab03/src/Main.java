public class Main {
    public static void main(String[] args){
        //TO-DO: deixar main nos conformes das instrucoes, por enquanto estamos usando apenas para testes rapidos

        ClientePJ pj1 = new ClientePJ("PJ1", "B", null, "A", "F", "C", "04.348.764/0001-23", null);
        ClientePJ pj2 = new ClientePJ("PJ2", "B", null, "A", "F", "C", "12.445.351/0001-95", null);
        ClientePF pf1 = new ClientePF("PF1", "B", null, "A", "F", "C", "132.104.950-17", null);
        ClientePF pf2 = new ClientePF("PF2", "B", null, "A", "F", "C", "436.370.260-58", null);

        if(pj1.validarCNPJ("19733821000165")){
            System.out.println("valido");
        }else{
            System.out.println("invalido");
        }
        Veiculo v1 = new Veiculo("1234", "honda", "carro", 2000);
        Veiculo v2 = new Veiculo("5555", "motorola", "carro", 2000);

        pj1.listaVeiculos.add(v1);
        pj1.listaVeiculos.add(v2);

        
        Veiculo v3 = new Veiculo("8888", "motorola", "carro", 2000);
        pj1.listaVeiculos.add(2, v3);
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

        System.out.println("geracao de sinistro "+seg.gerarSinistro(null, "casa", seg, v3, pj1));
        System.out.println("geracao de sinistro "+seg.gerarSinistro(null, "rua 2", seg, v3, pj1));

        System.out.println("geracao de sinistro "+seg.gerarSinistro(null, "casa", seg, v3, pf1));
        System.out.println("geracao de sinistro "+seg.gerarSinistro(null, "rua 2", seg, v3, pf1));

        System.out.println("geracao de sinistro "+seg.gerarSinistro(null, "rua 2", seg, v3, pf2));
        //System.out.println("listando clientes\n"+seg.listarClientes("pj"));
        //System.out.println("\nlistando sinistros\n"+seg.listarSinistros());
        System.out.println("visualizacao de sinistros "+seg.visualizarSinistro("436.370.260-58"));
    }
}
