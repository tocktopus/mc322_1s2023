/*
 * Frota.java
 * Ultima modificacao: 21/05/2023
 * Material usado na disciplina MC322
 */
import java.util.ArrayList;
import java.util.Random;

public class Frota {
    private Random random = new Random();
    private final String code;
    private ArrayList<Veiculo> listaVeiculos;

    //construtor
    public Frota(Veiculo veiculo) {
        this.code = Integer.toString(random.nextInt(1000));
        listaVeiculos = new ArrayList<Veiculo>();
        listaVeiculos.add(veiculo);
    }

    public String toString() {
        String dados = ""; 
        dados += "Code: " + this.code + "\nlistaVeiculos:\n" + this.listaVeiculos + "\n";

        return dados;
    }

    //metodos 
    
    /**
     * Insere um Veiculo na listaVeiculos da frota.
     * @param veiculo (Veiculo a ser inserido)
     * @return valor booleano (true se o veiculo nao estiver na lista, false do contrario)
     */
    public boolean cadastrarVeiculo(Veiculo veiculo){
        if(!listaVeiculos.contains(veiculo)){
            listaVeiculos.add(veiculo);
            return true;
        }
        return false;
    }

    /**
     * Remove um veiculo da listaVeiculos da frota.
     * @param veiculo (Veiculo que sera removido)
     * @return valor booleano (true se a lista conter o veiculo, false do contrario)
     */
    public boolean removerVeiculo(Veiculo veiculo){
        if(listaVeiculos.contains(veiculo)){
            listaVeiculos.remove(veiculo);
            return true;
        }
        return false;
    }

    /**
     * Remove um veiculo da listaVeiculos da frota a partir de sua placa.
     * @param placaVeiculo (placa do veiculo que sera removido)
     * @return valor booleano (true se a lista conter o veiculo, false do contrario)
     */
    public boolean removerVeiculo(String placaVeiculo){
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
