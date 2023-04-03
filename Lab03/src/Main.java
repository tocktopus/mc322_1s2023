public class Main {
    public static void main(String[] args){
        //TO-DO: deixar main nos conformes das instrucoes, por enquanto estamos usando apenas para testes rapidos

        ClientePJ c = new ClientePJ("A", "B", null, "A", "F", "C", "123", null);
        if(c.validarCNPJ("19733821000165")){
            System.out.println("valido");
        }else{
            System.out.println("invalido");
        }
        Veiculo v1 = new Veiculo("1234", "honda", "carro", 2000);
        Veiculo v2 = new Veiculo("5555", "motorola", "carro", 2000);

        c.listaVeiculos.add(v1);
        c.listaVeiculos.add(v2);

        
        Veiculo v3 = new Veiculo("8888", "motorola", "carro", 2000);
        c.listaVeiculos.add(2, v3);
        //System.out.println(c.getListaVeiculos());
        
        //System.out.println(c);

        Sinistro s = new Sinistro("30/06/2020", null, null, v3, c);

        System.out.println(s);
    }
}
