import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        //TO-DO: deixar main nos conformes das instrucoes, por enquanto estamos usando apenas para testes rapidos
        
        ClientePJ c = new ClientePJ(null, null, null, null, null, null, null, null, null);
        if(c.validarCNPJ("19733821000165")){
            System.out.println("valido");
        }else{
            System.out.println("invalido");
        }
        Veiculo v1 = new Veiculo("1234", "honda", "carro", 2000);
        Veiculo v2 = new Veiculo("5555", "motorola", "carro", 2000);

        ArrayList<Veiculo> veiculos = new ArrayList<Veiculo>();
        veiculos.add(v1);
        veiculos.add(v2);

        c.setListaVeiculos(veiculos);
        
        Veiculo v3 = new Veiculo("8888", "motorola", "carro", 2000);
        c.listaVeiculos.add(2, v3);
        //System.out.println(c.getListaVeiculos());
        
        System.out.println(c);
    }
}
