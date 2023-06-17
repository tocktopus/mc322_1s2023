import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class ArquivoClientePF implements I_Arquivo{
    private Seguradora seguradora;

    public ArquivoClientePF(Seguradora seguradora){
        this.seguradora = seguradora;
    }
    
    public boolean lerArquivo(String nome){
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(nome), "UTF-8"))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String cpf = values[0];
                String nomeCliente = values[1];
                String telefone = values[2];
                String endereco = values[3];
                String email = values[4];
                String genero = values[5];
                String educacao = values[6];
                String dataNasc = values[7];
                String placa = values[8];
                ClientePF c = new ClientePF(nomeCliente, cpf, telefone, endereco, email, genero, educacao, LocalDate.parse(dataNasc));
                
                c.cadastrarVeiculo(seguradora.getVeiculo(placa));
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
