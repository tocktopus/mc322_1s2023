import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class ArquivoSeguro implements I_Arquivo{
    private Seguradora seguradora;

    public ArquivoSeguro(Seguradora seguradora){
        this.seguradora = seguradora;
    }

    public boolean gravarArquivo(String nome){
        try(OutputStreamWriter bufferOut = new OutputStreamWriter(new FileOutputStream(nome),"UTF-8")){
            bufferOut.write("ID,DATA_INI,DATA_FIM,SEGURADORA,LISTA_SINISTROS,LISTA_CONDUTORES,VALOR_MENSAL\n");
            for(Seguro s : seguradora.listarSeguros()){
                bufferOut.write(s.getId()+","+s.getDataInicio()+","+s.getDataFim()+","+s.getSeguradora().getNome()+",\""+s.toStringListaSini()+"\",\""+s.toStringListaCond()+"\","+s.getValorMensal()+"\n");
            }
            bufferOut.close();
        }catch(Exception e){
            System.out.println("Arquivo SEGURO Inválido.");
            return false;
        }
        return true;
    }

    public boolean lerArquivo(String nome){
        return true;
    }
}