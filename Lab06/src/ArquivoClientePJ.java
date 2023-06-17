import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class ArquivoClientePJ implements I_Arquivo{
    private Seguradora seguradora;

    public ArquivoClientePJ(Seguradora seguradora){
        this.seguradora = seguradora;
    }
    
    public boolean lerArquivo(String nome){
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nome), "UTF-8"))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String cnpj = values[0];
                String nomeEmpresa = values[1];
                String telefone = values[2];
                String endereco = values[3];
                String email = values[4];
                String dataFund = values[5];
                String codeFrota = values[6];
                
                ClientePJ c = new ClientePJ(nomeEmpresa, cnpj, telefone, endereco, email, LocalDate.parse(dataFund), 0);
                
                c.cadastrarFrota(seguradora.getFrota(codeFrota));
                seguradora.cadastrarCliente(c);
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
