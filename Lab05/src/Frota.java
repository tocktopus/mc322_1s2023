import java.util.ArrayList;
import java.util.Random;

public class Frota {
    private Random random = new Random();
    private final String code;
    private ArrayList<Veiculo> listaVeiculos;

    //construtor
    public Frota() {
        this.code = Integer.toString(random.nextInt(1000));
        listaVeiculos = new ArrayList<Veiculo>();
    }

    public String toString() {
        String dados = ""; 
        dados += "Code: " + this.code + "\nlistaVeiculos: " + this.listaVeiculos + "\n";

        return dados;
    }

    //metodos 
    public boolean cadastrarVeiculo(Veiculo veiculo){
        //Insere um Veiculo na listaVeiculos da frota.
        //Entrada: Veiculo a ser inserido
        //Saida: valor booleano (true se o veiculo nao estiver na lista, false do contrario)
         
        if(!listaVeiculos.contains(veiculo)){
            listaVeiculos.add(veiculo);
            return true;
        }
        return false;
    }

    public boolean removerVeiculo(Veiculo veiculo){
        //Remove um veiculo da listaVeiculos da frota.
        //Entrada: Veiculo que sera removido
        //Saida: valor booleano (true se a lista conter o veiculo, false do contrario)
        
        if(listaVeiculos.contains(veiculo)){
            listaVeiculos.remove(veiculo);
            return true;
            
        }
        return false;
    }

    public boolean removerVeiculo(String placaVeiculo){
        //Remove um veiculo da listaVeiculos da frota a partir de sua placa.
        //Entrada: String contendo a placa do veiculo que sera removido
        //Saida: valor booleano (true se encontrar um veiculo com essa placa, false do contrario)
        
        for(Veiculo v : listaVeiculos){
            if(v.getPlaca().equals(placaVeiculo)){
                listaVeiculos.remove(v);
                return true;
            }
        }
        return false;
    }

    //getters e setters
    public String getCode() {
        return code;
    }

    public ArrayList<Veiculo> getListaVeiculos() {
        return listaVeiculos;
    }

    public void setListaVeiculos(ArrayList<Veiculo> listaVeiculos) {
        this.listaVeiculos = listaVeiculos;
    }

    
    
}
