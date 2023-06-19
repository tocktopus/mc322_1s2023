import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class ArquivoSinistro{
private Seguradora seguradora;

    public ArquivoSinistro(Seguradora seguradora){
        this.seguradora = seguradora;
    }

    public boolean gravarArquivo(String nome){
        try(OutputStreamWriter bufferOut = new OutputStreamWriter(new FileOutputStream(nome),"UTF-8")){
            bufferOut.write("ID,DATA,ENDERECO,CONDUTOR,SEGURO\n");
            for(Sinistro s : seguradora.listarSinistros()){
                bufferOut.write(s.getId()+","+s.getData()+","+s.getEndereco()+","+s.getCondutor().getCpf()+","+s.getSeguro().getId()+"\n");
            }
            bufferOut.close();
        }catch(Exception e){
            System.out.println("Arquivo Inválido.");
            return false;
        }
        return true;
    }

    public boolean lerArquivo(String nome){
        return true;
    }
}