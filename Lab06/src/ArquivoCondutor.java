import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class ArquivoCondutor implements I_Arquivo{
    private Seguradora seguradora;

    public ArquivoCondutor(Seguradora seguradora){
        this.seguradora = seguradora;
    }
    
    public boolean lerArquivo(String nome){
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nome), "UTF-8"))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String cpf = values[0];
                String nomeCond = values[1];
                String telefone = values[2];
                String endereco = values[3];
                String email = values[4];
                String dataNasc = values[5];
                
                Condutor c = new Condutor(cpf, nomeCond, telefone, endereco, email, LocalDate.parse(dataNasc));
                
                seguradora.getListaCondutores().add(c);
            }
            br.close();

        }catch(Exception e){
            System.out.println("Arquivo Inválido.");
            return false;
        }
        return true;
    }

    public boolean gravarArquivo(String nome){
        return true;
    }
}