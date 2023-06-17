import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class ArquivoFrota implements I_Arquivo{
    private Seguradora seguradora;

    public ArquivoFrota(Seguradora seguradora){
        this.seguradora = seguradora;
    }
    public boolean lerArquivo(String nome){

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/arquivos/frotas.csv"), "UTF-8"))) {
            String line;
            line = br.readLine(); //pra pular o cabecalho
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String code = values[0];
                String placa1 = values[1];
                String placa2 = values[2];
                String placa3 = values[3];
                

                Frota f = new Frota(code, seguradora.getVeiculo(placa1));
                f.cadastrarVeiculo(seguradora.getVeiculo(placa2));
                f.cadastrarVeiculo(seguradora.getVeiculo(placa3));
                seguradora.getListaFrotas().add(f);
                
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