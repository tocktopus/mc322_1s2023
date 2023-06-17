import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ArquivoVeiculo implements I_Arquivo{
    private Seguradora seguradora;

    public ArquivoVeiculo(Seguradora seguradora){
        this.seguradora = seguradora;
    }
    public boolean lerArquivo(String nome){

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nome), "UTF-8"))) {
            String line;
            line = br.readLine(); //pra pular o cabecalho
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String placa = values[0];
                String marca = values[1];
                String modelo = values[2];
                int ano = Integer.parseInt(values[3]);
                
                Veiculo v = new Veiculo(placa, marca, modelo, ano);
                seguradora.getListaVeiculos().add(v);
            }
            br.close();

        }catch(Exception e){
            System.out.println("Arquivo Inválido.");
            return false;
        }
        return true;
    }

    public boolean gravarArquivo(){
        return true;
    }
}