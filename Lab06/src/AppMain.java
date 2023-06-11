import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.util.ArrayList;


public class AppMain {
    private static ArrayList<Veiculo> listaVeiculos = new ArrayList<Veiculo>();
    private static ArrayList<Frota> listaFrotas = new ArrayList<Frota>();
    public static void main(String[] args) {
        

        Seguradora seg = new Seguradora("79.382.176/0001-05", "Hello World Seguros", "12345678", "hw@gmail.com", "Avenida 1");
        
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/arquivos/veiculos.csv"), "UTF-8"))) {
            String line;
            line = br.readLine(); //pra pular o cabecalho
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String placa = values[0];
                String marca = values[1];
                String modelo = values[2];
                int ano = Integer.parseInt(values[3]);
                
                Veiculo v = new Veiculo(placa, marca, modelo, ano);
                listaVeiculos.add(v);
                
            }

        }catch(Exception e){
            System.out.println("Arquivo Inválido.");
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/arquivos/frotas.csv"), "UTF-8"))) {
            String line;
            line = br.readLine(); //pra pular o cabecalho
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String code = values[0];
                String placa1 = values[1];
                String placa2 = values[2];
                String placa3 = values[3];
                

                Frota f = new Frota(code, getVeiculo(placa1));
                f.cadastrarVeiculo(getVeiculo(placa2));
                f.cadastrarVeiculo(getVeiculo(placa3));
                listaFrotas.add(f);
                
            }

        }catch(Exception e){
            System.out.println("Arquivo Inválido.");
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/arquivos/clientesPF.csv"), "UTF-8"))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String cpf = values[0];
                String nome = values[1];
                String telefone = values[2];
                String endereco = values[3];
                String email = values[4];
                String genero = values[5];
                String educacao = values[6];
                String dataNasc = values[7];
                String placa = values[8];
                ClientePF c = new ClientePF(nome, cpf, telefone, endereco, email, genero, educacao, LocalDate.parse(dataNasc));
                
                c.cadastrarVeiculo(getVeiculo(placa));
                seg.cadastrarCliente(c);
                //System.out.println(c);
            }
            
        }catch(Exception e){
            System.out.println("Arquivo Inválido.");
        }

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/arquivos/clientesPJ.csv"), "UTF-8"))) {
            String line;
            line = br.readLine();
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                String cnpj = values[0];
                String nome = values[1];
                String telefone = values[2];
                String endereco = values[3];
                String email = values[4];
                String dataFund = values[5];
                String codeFrota = values[6];
                
                ClientePJ c = new ClientePJ(nome, cnpj, telefone, endereco, email, LocalDate.parse(dataFund), 0);
                
                c.cadastrarFrota(getFrota(codeFrota));
                seg.cadastrarCliente(c);
                //System.out.println(c);
            }
            
        }catch(Exception e){
            System.out.println("Arquivo Inválido.");
        }

        

        seg.gerarSeguro(new SeguroPF(LocalDate.parse("2020-02-02"), LocalDate.parse("2020-08-02"), seg, listaVeiculos.get(0), (ClientePF)seg.listarClientes("pf").get(0)));
        seg.gerarSeguro(new SeguroPJ(LocalDate.parse("2020-02-02"), LocalDate.parse("2020-08-02"), seg, listaFrotas.get(0), (ClientePJ)seg.listarClientes("pj").get(0)));

        Condutor c1 = new Condutor("132.104.950-17", "João", "99999-9999", "Rua A", "PF@gmail.com", LocalDate.parse("1995-05-13"));
        Condutor c2 = new Condutor("799.634.220-20", "Maria", "91234-5678", "Rua F", "maria@gmail.com", LocalDate.parse("1985-02-24"));
        
        //autorizando condutores para cada um dos seguros
        seg.getSeguroPorID(0).autorizarCondutor(c1);
        seg.getSeguroPorID(1).autorizarCondutor(c2);

        //gerando sinistros para cada um dos seguros
        seg.getSeguroPorID(0).gerarSinistro(new Sinistro(LocalDate.parse("2023-05-24"), "Centro", seg.getSeguroPorID(0), c1));
        seg.getSeguroPorID(1).gerarSinistro(new Sinistro(LocalDate.parse("2023-05-24"), "Rua X", seg.getSeguroPorID(1), c2));

        try(OutputStreamWriter bufferOut = new OutputStreamWriter(new FileOutputStream("src/arquivos/seguros.csv"),"UTF-8")){
            bufferOut.write("ID,DATA_INI,DATA_FIM,SEGURADORA,LISTA_SINISTROS,LISTA_CONDUTORES,VALOR_MENSAL\n");
            for(Seguro s : seg.listarSeguros()){
                bufferOut.write(s.getId()+","+s.getDataInicio()+","+s.getDataFim()+","+s.getSeguradora().getNome()+","+s.toStringListaSini()+","+s.toStringListaCond()+","+s.getValorMensal()+"\n");
            }
            bufferOut.close();
        }catch(Exception e){
            System.out.println("erro");
        }
        try(OutputStreamWriter bufferOut = new OutputStreamWriter(new FileOutputStream("src/arquivos/sinistros.csv"),"UTF-8")){
            bufferOut.write("ID,DATA_INI,DATA_FIM,LISTA_SINISTROS,LISTA_CONDUTORES,VALOR_MENSAL\n");
            for(Sinistro s : seg.listarSinistros()){
                bufferOut.write(s.getId()+","+s.getData()+","+s.getEndereco()+","+s.getCondutor().getCpf()+","+s.getSeguro().getId()+"\n");
            }
            bufferOut.close();
        }catch(Exception e){
            System.out.println("erro");
        }
		

		

    }
    
    
    public static Veiculo getVeiculo(String placa){
        for(Veiculo v : listaVeiculos){
            if(v.getPlaca().equals(placa)){
                return v;
            }
        }
        return null;
    }

    public static Frota getFrota(String code){
        for(Frota f : listaFrotas){
            if(f.getCode().equals(code)){
                return f;
            }
        }
        return null;
    }
}
