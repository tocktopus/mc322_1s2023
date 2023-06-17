/*
 * Seguro.java
 * Ultima modificacao: 21/05/2023
 * Material usado na disciplina MC322
 * 
 * to-do: implementar interface arquivo e tratar exceptions
 */


import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class AppMain {
    //cria lista que vai conter todas as seguradoras do programa
    private static ArrayList<Seguradora> seguradoras = new ArrayList<Seguradora>();

    public static void main(String[] args) {
        Seguradora seg = new Seguradora("79.382.176/0001-05", "Hello World Seguros", "12345678", "hw@gmail.com", "Avenida 1");
        seguradoras.add(seg);

        seg.lerDados("veiculo","src/arquivos/veiculos.csv");
        seg.lerDados("frota", "src/arquivos/frotas.csv");
        seg.lerDados("clientepf", "src/arquivos/clientesPF.csv");
        seg.lerDados("clientepj", "src/arquivos/clientesPJ.csv");
        seg.lerDados("condutor", "src/arquivos/condutores.csv");
        System.out.println(seg.getListaCondutores());
        /*try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/arquivos/veiculos.csv"), "UTF-8"))) {
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
            br.close();

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
            br.close();

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
            br.close();

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
            br.close();
            
        }catch(Exception e){
            System.out.println("Arquivo Inválido.");
        }*/

        

        /*seg.gerarSeguro(new SeguroPF(LocalDate.parse("2020-02-02"), LocalDate.parse("2020-08-02"), seg, listaVeiculos.get(0), (ClientePF)seg.listarClientes("pf").get(0)));
        seg.gerarSeguro(new SeguroPJ(LocalDate.parse("2020-02-02"), LocalDate.parse("2020-08-02"), seg, listaFrotas.get(0), (ClientePJ)seg.listarClientes("pj").get(0)));

        Condutor c1 = new Condutor("132.104.950-17", "João", "99999-9999", "Rua A", "PF@gmail.com", LocalDate.parse("1995-05-13"));
        Condutor c2 = new Condutor("799.634.220-20", "Maria", "91234-5678", "Rua F", "maria@gmail.com", LocalDate.parse("1985-02-24"));
        
        //autorizando condutores para cada um dos seguros
        seg.getSeguroPorID(0).autorizarCondutor(c1);
        seg.getSeguroPorID(1).autorizarCondutor(c2);

        //gerando sinistros para cada um dos seguros
        seg.getSeguroPorID(0).gerarSinistro(new Sinistro(LocalDate.parse("2023-05-24"), "Centro", seg.getSeguroPorID(0), c1));
        seg.getSeguroPorID(1).gerarSinistro(new Sinistro(LocalDate.parse("2023-05-24"), "Rua X", seg.getSeguroPorID(1), c2));
*/
        criarMenu();

        //gravando dados nos arquivos
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
		
        //System.out.println(seg.listarClientes());
		

    }

    
    public static void criarMenu(){
        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.ENGLISH); //para aceitar valores double usando ponto ao invés de vírgula

        loop: while (true){
            System.out.println("\n ----MENU----\nEscolha uma das opções digitando o número correspondente:\n"+
                                "1 Cadastrar\n"+
                                "2 Listar\n"+
                                "3 Excluir\n"+
                                "4 Gerar Seguro\n"+
                                "5 Cancelar Seguro\n"+
                                "6 Autorizar Condutor\n"+
                                "7 Desautorizar Condutor\n"+
                                "8 Gerar Sinistro\n"+
                                "9 Calcular Receita\n"+
                                "0 Sair");

            MenuOperacoes operacao = MenuOperacoes.valor(entrada.nextDouble());
            
            
            switch(operacao){
                case CADASTRAR:{
                    System.out.println("\n----CADASTRAR----\nEscolha uma das opções digitando o número correspondente:\n"+
                                        "1.1 Cadastrar Cliente\n"+
                                        "1.2 Cadastrar Veículo\n"+
                                        "1.3 Cadastrar Frota\n"+
                                        "1.4 Cadastrar Seguradora\n"+
                                        "1.5 Voltar");
                    MenuOperacoes opCad = MenuOperacoes.valor(entrada.nextDouble());
                    
                    switch(opCad){
                        case CAD_CLIENTE:{
                            Seguradora s = getSeguradora(entrada);

                            System.out.println("Insira o tipo de cliente (digite \"pf\" para pessoa física, \"pj\" para pessoa jurídica): ");
                            String tipo = entrada.nextLine();
                            switch(tipo){
                                case "pf":{
                                    System.out.println("Inserção de dados do novo ClientePF\nNome: ");
                                    String nome = entrada.nextLine();
                                    System.out.println("CPF: ");
                                    String cpf = entrada.nextLine();
                                    System.out.println("Telefone: ");
                                    String telefone = entrada.nextLine();
                                    System.out.println("Endereço: ");
                                    String endereco = entrada.nextLine();
                                    System.out.println("Email: ");
                                    String email = entrada.nextLine();
                                    System.out.println("Gênero: ");
                                    String genero = entrada.nextLine();
                                    System.out.println("Educação: ");
                                    String educacao = entrada.nextLine();
                                    System.out.println("Data de nascimento (formato aaaa-mm-dd): ");
                                    String dataNasc = entrada.nextLine();

                                    ClientePF clientePF = new ClientePF(nome, cpf, telefone, endereco, email, genero, educacao, LocalDate.parse(dataNasc));
                                    
                                    if(s.cadastrarCliente(clientePF)){
                                        System.out.println("Cliente cadastrado com sucesso!");
                                    }else{
                                        System.out.println("Falha no cadastro. Verifique se os dados estão corretos.");
                                    }
                                }break;

                                case "pj":{
                                    System.out.println("Inserção de dados do novo ClientePJ\nNome: ");
                                    String nome = entrada.nextLine();
                                    System.out.println("CNPJ: ");
                                    String cnpj = entrada.nextLine();
                                    System.out.println("Telefone: ");
                                    String telefone = entrada.nextLine();
                                    System.out.println("Endereço: ");
                                    String endereco = entrada.nextLine();
                                    System.out.println("Email: ");
                                    String email = entrada.nextLine();
                                    System.out.println("Data de fundação (formato aaaa-mm-dd): ");
                                    String dataFund = entrada.nextLine();
                                    System.out.println("Quantidade de funcionários: ");
                                    int qtdFunc = entrada.nextInt();

                                    ClientePJ clientePJ = new ClientePJ(nome, cnpj, telefone, endereco, email, LocalDate.parse(dataFund), qtdFunc);
                                    if(s.cadastrarCliente(clientePJ)){
                                        System.out.println("Cliente cadastrado com sucesso!");
                                    }else{
                                        System.out.println("Falha no cadastro. Verifique se os dados estão corretos.");
                                    }
                                }break;

                                default:
                                    System.out.println("Comando inválido");
                                break;
                            }
                        }break;

                        case CAD_VEICULO:{
                            Seguradora s = getSeguradora(entrada);

                            System.out.println("Insira o cpf/cnpj do cliente ao qual será cadastrado o veículo:");
                            String cliente = entrada.nextLine();
                            Cliente c = s.encontrarCliente(cliente);
                            if(c instanceof ClientePF){
                                ClientePF k = (ClientePF)c; //faz o downcasting
                                System.out.println("Inserção de dados do novo Veículo\nPlaca: ");
                                String placa = entrada.nextLine();
                                System.out.println("Marca: ");
                                String marca = entrada.nextLine();
                                System.out.println("Modelo: ");
                                String modelo = entrada.nextLine();
                                System.out.println("Ano de fabricação: ");
                                int ano = entrada.nextInt();
                                Veiculo v = new Veiculo(placa, marca, modelo, ano);
                                if(k.cadastrarVeiculo(v)){
                                    System.out.println("Veiculo cadastrado com sucesso!");
                                }else{
                                    System.out.println("Falha no cadastro.");
                                }
                            }else if(c instanceof ClientePJ){
                                ClientePJ k = (ClientePJ)c; //faz o downcasting
                                System.out.println("Inserção de dados do novo Veículo\nCódigo da frota: ");
                                String code = entrada.nextLine();
                                System.out.println("Placa: ");
                                String placa = entrada.nextLine();
                                System.out.println("Marca: ");
                                String marca = entrada.nextLine();
                                System.out.println("Modelo: ");
                                String modelo = entrada.nextLine();
                                System.out.println("Ano de fabricação: ");
                                int ano = entrada.nextInt();
                                Veiculo v = new Veiculo(placa, marca, modelo, ano);

                                if(k.atualizarFrota(code, v)){
                                    System.out.println("Veículo cadastrado com sucesso!");
                                }else{
                                    System.out.println("Falha no cadastro, verifique se o código está correto.");
                                }
                            }else{
                                System.out.println("Cliente inválido.");
                            }

                        }break;

                        case CAD_FROTA:{
                            Seguradora s = getSeguradora(entrada);
                            
                            System.out.println("Insira o cnpj do cliente ao qual será cadastrada a frota");
                            String cliente = entrada.nextLine();
                            Cliente c = s.encontrarCliente(cliente);

                            if(c instanceof ClientePJ){
                                ClientePJ k = (ClientePJ)c; //faz o downcasting
                                System.out.println("Inserção de dados da nova Frota\nCódigo:");
                                String code = entrada.nextLine();
                                System.out.println("Placa do novo veículo: ");
                                String placa = entrada.nextLine();
                                System.out.println("Marca: ");
                                String marca = entrada.nextLine();
                                System.out.println("Modelo: ");
                                String modelo = entrada.nextLine();
                                System.out.println("Ano de fabricação: ");
                                int ano = entrada.nextInt();
                                Veiculo v = new Veiculo(placa, marca, modelo, ano);
                                Frota f = new Frota(code, v);
                                if(k.cadastrarFrota(f)){
                                    System.out.println("Frota cadastrada com sucesso!");
                                }else{
                                    System.out.println("Falha no cadastro");
                                }
                            }else{
                                System.out.println("Cliente inválido");
                            }
                        }break;
                        
                        case CAD_SEGURADORA:{
                            entrada.nextLine(); //para nao pular o proximo
                            System.out.println("Inserção de dados da nova Seguradora\nNome:");
                            String nome = entrada.nextLine();
                            System.out.println("CNPJ: ");
                            String cnpj = entrada.nextLine();
                            System.out.println("Telefone: ");
                            String telefone = entrada.nextLine();
                            System.out.println("Email: ");
                            String email = entrada.nextLine();
                            System.out.println("Endereço: ");
                            String endereco = entrada.nextLine();

                            Seguradora seg = new Seguradora(cnpj, nome, telefone, email, endereco);
                            seguradoras.add(seg);
                            System.out.println("Seguradora cadastrada");
                        }break;

                        case VOLTAR_CAD:
                            continue loop;
                        

                        default:
                            System.out.println("Operação inválida");
                        break;

                    }
                }break;

                case LISTAR:{
                    System.out.println("\n----LISTAR----\nEscolha uma das opções digitando o número correspondente:\n"+
                                "2.1 Listar Cliente por Seguradora\n"+
                                "2.2 Listar Seguros\n"+
                                "2.3 Listar Sinistros\n"+
                                "2.4 Listar Condutores de Seguro\n"+
                                "2.5 Listar Frotas de Pessoa Jurídica\n"+
                                "2.6 Listar Veiculos de Pessoa Física\n"+
                                "2.7 Voltar");
                    MenuOperacoes opListar = MenuOperacoes.valor(entrada.nextDouble());

                    switch(opListar){
                        case LISTAR_CLIENTE:{
                            Seguradora s = getSeguradora(entrada);

                            System.out.println("Insira o tipo de cliente (digite \"pf\" para pessoa física, \"pj\" para pessoa jurídica): ");
                            String tipo = entrada.nextLine();
                            
                            if(tipo.equals("pf") || tipo.equals("pj")){
                                System.out.println("Listando clientes "+tipo+" da Seguradora "+s.getNome() + ":\n" + s.listarClientes(tipo));
                            }else{
                                System.out.println("Comando inválido.");
                            }
                        }break;

                        case LISTAR_SEGURO:{
                            Seguradora s = getSeguradora(entrada);

                            System.out.println("Como deseja listar os Seguros? (Digite \"seguradora\" para listar Seguros por Seguradora, \"cliente\" para listar por Cliente)");
                            String tipo = entrada.nextLine();
                            switch(tipo){
                                case "seguradora":{
                                    System.out.println("Listando Seguros da Seguradora "+s.getNome() + ":\n" + s.listarSeguros());
                                }break;

                                case "cliente":{
                                    System.out.println("Insira o cpf/cnpj do cliente cujos Seguros deseja listar");
                                    String cliente = entrada.nextLine();
                                    ArrayList<Seguro> seguros = s.getSegurosPorCliente(cliente);
                                    if(seguros.isEmpty()){
                                        System.out.println("Esse cliente não existe ou não possui seguros associados.");
                                    }else{
                                        System.out.println("Listando Seguros do Cliente "+ cliente + ":\n" + seguros);
                                    }
                                }break;

                                default:
                                    System.out.println("Comando inválido.");
                                break;
                            }
                        }break;

                        case LISTAR_SINISTROS:{
                            Seguradora s = getSeguradora(entrada);

                            System.out.println("Como deseja listar os Sinistros? (Digite \"seguradora\" para listar Seguros por Seguradora, \"cliente\" para listar por Cliente, e \"seguro\" para listar por Seguro)");
                            String tipo = entrada.nextLine();

                            switch(tipo){
                                case "seguradora":{                                 
                                    System.out.println("Listando Sinistros da Seguradora "+s.getNome() + ":\n" + s.listarSinistros());

                                }break;

                                case "cliente":{
                                    System.out.println("Insira o cpf/cnpj do cliente cujos Sinistros deseja listar");
                                    String cliente = entrada.nextLine();
                                    ArrayList<Sinistro> sinistros = s.getSinistrosPorCliente(cliente);
                                    if(sinistros.isEmpty()){
                                        System.out.println("Esse cliente não existe ou não possui Sinistros associados.");
                                    }else{
                                        System.out.println("Listando Sinistros do Cliente "+ cliente + ":\n" + sinistros);
                                    }
                                }break;

                                case "seguro":{
                                    System.out.println("Insira o ID do Seguro cujos Sinistros deseja listar");
                                    int id = entrada.nextInt();
                                    ArrayList<Sinistro> sinistros = s.getSinistrosPorSeguro(id);
                                    if(sinistros != null){ 
                                        System.out.println("Listando Sinistros do Seguro "+ id + ":\n" + sinistros);
                                    }else{
                                        System.out.println("ID inválido.");
                                    }
                                }break;

                                default:
                                    System.out.println("Comando inválido.");
                                break;
                            }
                        }break;

                        case LISTAR_CONDUTORES:{
                            Seguradora s = getSeguradora(entrada);

                            System.out.println("Insira o ID do Seguro cujos Condutores deseja listar");
                            int id = entrada.nextInt();
                            ArrayList<Condutor> condutores = s.getCondutoresPorSeguro(id);
                            if(condutores != null){ 
                                System.out.println("Listando Condutores do Seguro "+ id + ":\n" + condutores);
                            }else{
                                System.out.println("ID inválido.");
                            }

                        }break;

                        case LISTAR_FROTAS:{
                            Seguradora s = getSeguradora(entrada);

                            System.out.println("Insira o cnpj do cliente cujas Frotas deseja listar");

                            String cliente = entrada.nextLine();
                            Cliente c = s.encontrarCliente(cliente);
                            if (c instanceof ClientePJ) {
                                ClientePJ k = (ClientePJ)c;
                                System.out.println("Listando Frotas do Cliente "+ cliente + ":\n" +k.getListaFrota());
                            }else{
                                System.out.println("Cliente inválido.");
                            }

                        }break;

                        case LISTAR_VEICULOS:{
                            Seguradora s = getSeguradora(entrada);

                            System.out.println("Insira o cpf do cliente cujos Veículos deseja listar:");
                            String cliente = entrada.nextLine();
                            Cliente c = s.encontrarCliente(cliente);

                            if (c instanceof ClientePF) {
                                ClientePF k = (ClientePF)c;
                                System.out.println("Listando Veiculos do Cliente "+ cliente + ":\n" +k.getListaVeiculos());
                            }else{
                                System.out.println("Cliente inválido.");
                            }
                        }break;

                        case VOLTAR_LISTAR:
                            continue loop;

                        default:
                            System.out.println("Operação inválida.");
                        break;

                    }

                }break;
 
                case EXCLUIR:{
                System.out.println("\n ----EXCLUIR----\nEscolha uma das opções digitando o número correspondente:\n"+
                                        "3.1 Excluir Cliente\n"+
                                        "3.2 Excluir Veículo\n"+
                                        "3.3 Excluir Frota\n"+
                                        "3.4 Voltar");
                    MenuOperacoes opExcluir = MenuOperacoes.valor(entrada.nextDouble());
                    
                    switch(opExcluir){
                        case EXCLUIR_CLIENTE:{
                            Seguradora s = getSeguradora(entrada);

                            System.out.println("Insira o cpf/cnpj do cliente que deseja excluir:");
                            String cliente = entrada.nextLine();
                            if(s.removerCliente(cliente)){
                                System.out.println("Cliente removido com sucesso.");
                                
                            }else{
                                System.out.println("Cliente não encontrado.");
                            }
                        }break;

                        case EXCLUIR_VEICULO:{
                            Seguradora s = getSeguradora(entrada);

                            System.out.println("Insira o cpf/cnpj do cliente dono do veículo:");
                            String cliente = entrada.nextLine();
                            Cliente c = s.encontrarCliente(cliente);
                            
                            if(c instanceof ClientePF){
                                ClientePF k = (ClientePF)c;
                                System.out.println("Insira a placa do veículo a ser removido:");
                                String placa = entrada.nextLine();
                                if(k.removerVeiculo(placa)){
                                    System.out.println("Veiculo excluido com sucesso.");
                                }else{
                                    System.out.println("Veiculo não encontrado.");
                                }

                            }else if(c instanceof ClientePJ){
                                ClientePJ k = (ClientePJ)c;

                                System.out.println("Insira o código da frota com o veículo a ser removido:");
                                String code = entrada.nextLine();
                                System.out.println("Insira a placa do veículo a ser removido:");
                                String placa = entrada.nextLine();

                                if(k.atualizarFrota(code, placa)){
                                    System.out.println("Veiculo excluido com sucesso.");
                                }else{
                                    System.out.println("Veiculo ou frota não encontrados.");
                                }
                            }else{
                                System.out.println("Cliente inválido.");  
                            }
                        }break;

                        case EXCLUIR_FROTA:{
                            Seguradora s = getSeguradora(entrada);

                            System.out.println("Insira o cnpj do cliente dono da frota:");
                            String cliente = entrada.nextLine();
                            Cliente c = s.encontrarCliente(cliente);
                            if (c instanceof ClientePJ) {
                                ClientePJ k = (ClientePJ)c;
                                System.out.println("Insira o código da frota a ser removida:");
                                String code = entrada.nextLine();
                                if(k.atualizarFrota(code)){
                                    System.out.println("Frota excluida com sucesso.");
                                }else{
                                    System.out.println("Frota não encontrada.");
                                }
                            }else{
                                System.out.println("Cliente inválido.");
                            }
                        }break;

                        case VOLTAR_EXCLUIR:
                            continue loop;

                        default:
                            System.out.println("Operação inválida.");
                        break;

                    }
                }break;

                case GERAR_SEGURO:{
                    Seguradora s = getSeguradora(entrada);

                    System.out.println("Insira o cpf/cnpj do cliente dono do veículo:");
                    String cliente = entrada.nextLine();
                    Cliente c = s.encontrarCliente(cliente);
                    if(c instanceof ClientePF){
                        ClientePF k = (ClientePF) c;
                        System.out.println("Inserção de dados do Seguro\nData de início (formato aaaa-mm-dd): ");
                        String dataIni = entrada.nextLine();
                        System.out.println("Data de fim (formato aaaa-mm-dd): ");
                        String dataFim = entrada.nextLine();
                        System.out.println("Placa do veiculo: ");
                        Veiculo v = k.getVeiculoPorPlaca(entrada.nextLine());
                        if(v != null && s.gerarSeguro(new SeguroPF(LocalDate.parse(dataIni), LocalDate.parse(dataFim), s, v, k))){
                            System.out.println("Seguro gerado com sucesso.");
                        }else{
                            System.out.println("Seguro não gerado. Verifique se o veículo está cadastrado.");
                        }

                    }else if(c instanceof ClientePJ){
                        ClientePJ k = (ClientePJ) c;
                        System.out.println("Inserção de dados do Seguro\nData de início (formato aaaa-mm-dd): ");
                        String dataIni = entrada.nextLine();
                        System.out.println("Data de fim (formato aaaa-mm-dd): ");
                        String dataFim = entrada.nextLine();
                        System.out.println("Código da Frota: ");
                        Frota f = k.getFrotaPorCode(entrada.nextLine());
                        if(f != null && s.gerarSeguro(new SeguroPJ(LocalDate.parse(dataIni), LocalDate.parse(dataFim), s, f, k))){
                            System.out.println("Seguro gerado com sucesso.");
                        }
                        else{
                            System.out.println("Falha em gerar seguro. Verifique se a frota está cadastrada.");
                        }
                    }else{
                        System.out.println("Cliente inválido.");
                    }


                }break;

                case CANCELAR_SEGURO:{
                    Seguradora s = getSeguradora(entrada);

                    System.out.println("Insira o id do seguro a ser cancelado:");
                    int id = entrada.nextInt();
                    if(s.cancelarSeguro(id)){
                        System.out.println("Seguro cancelado com sucesso");
                    }else{
                        System.out.println("Falha em cancelar seguro. Verifique o id.");
                    }
                }break;

                case AUTORIZAR_CONDUTOR:{
                    Seguradora s = getSeguradora(entrada);

                    System.out.println("Insira o id do seguro:");
                    int id = entrada.nextInt();
                    entrada.nextLine();//para nao pular o proximo

                    Seguro seguro = s.getSeguroPorID(id);
                    if(seguro != null){
                        System.out.println("Inserção de dados do Condutor\nNome: ");
                        String nome = entrada.nextLine();
                        System.out.println("CPF: ");
                        String cpf = entrada.nextLine();
                        System.out.println("Telefone: ");
                        String tel = entrada.nextLine();
                        System.out.println("Endereco: ");
                        String endereco = entrada.nextLine();
                        System.out.println("Email: ");
                        String email = entrada.nextLine();
                        System.out.println("Data de nascimento (formato aaaa-mm-dd): ");
                        String dataNasc = entrada.nextLine();
                        Condutor c = new Condutor(cpf, nome, tel, endereco, email, LocalDate.parse(dataNasc));
                        if(seguro.autorizarCondutor(c)){
                            System.out.println("Condutor autorizado.");
                        }else{
                            System.out.println("Falha em autorizar condutor. Verifique o cpf inserido.");
                        }
                    }
                }break;

                case DESAUTORIZAR_CONDUTOR:{
                    Seguradora s = getSeguradora(entrada);

                    System.out.println("Insira o id do seguro:");
                    int id = entrada.nextInt();
                    entrada.nextLine();//para nao pular o proximo

                    Seguro seguro = s.getSeguroPorID(id);
                    if(seguro != null){
                        System.out.println("Insira o cpf do condutor a ser desautorizado: ");
                        String cpf = entrada.nextLine();
                        if(seguro.desautorizarCondutor(cpf)){
                            System.out.println("Condutor desautorizado.");
                        }else{
                            System.out.println("Condutor não encontrado.");
                        }
                    }else{
                        System.out.println("ID inválido.");
                    }
                }break;

                case GERAR_SINISTRO:{
                    Seguradora s = getSeguradora(entrada);

                    System.out.println("Insira o id do seguro:");
                    int id = entrada.nextInt();
                    entrada.nextLine();//para nao pular o proximo

                    Seguro seguro = s.getSeguroPorID(id);
                    if(seguro != null){
                        System.out.println("Data do sinistro (formato aaaa-mm-dd): ");
                        String data = entrada.nextLine();
                        System.out.println("Endereco: ");
                        String endereco = entrada.nextLine();

                        System.out.println("CPF do condutor: ");
                        Condutor c = seguro.getCondutorPorCPF(entrada.nextLine());

                        if(c != null && seguro.gerarSinistro(new Sinistro(LocalDate.parse(data), endereco, seguro, c))){
                            System.out.println("Sinistro gerado com sucesso!");
                        }else{
                            System.out.println("Falha em gerar sinistro. Verifique se o condutor está cadastrado no seguro.");
                        }
                    }else{
                        System.out.println("ID inválido.");
                    }
                }break;

                case CALC_RECEITA:{
                    Seguradora s = getSeguradora(entrada);
                    System.out.println("Balanço de seguros da seguradora " + s.getNome() + ":");
                    s.calcularReceita();
                }break;

                case SAIR:
                    System.out.println("Saindo...");
                    break loop;

                default:
                    System.out.println("Operação inválida.");
                break;
            }
        }
        entrada.close();
    }

    /**
     * Imprime todas as seguradoras existentes e seus respectivos ids
     */
    public static void imprimirIDSeguradoras(){
        System.out.println("Escolha uma das seguradoras digitando seu id:");
        for (int i=0; i < seguradoras.size(); i++){
            System.out.println("ID "+ i + " - "+ seguradoras.get(i).getNome());
        }
    }

    /**
     * Recebe um id digitado pelo usuário até ele digitar um id válido, e então retorna a Seguradora correspondente
     * @param entrada (scanner para fazer a entrada de dados)
     * @return Seguradora encontrada
     */
    public static Seguradora getSeguradora(Scanner entrada){
        imprimirIDSeguradoras();

        int idSeg = entrada.nextInt();
        while(idSeg < 0 || idSeg >= seguradoras.size()){
            System.out.println("Digite um id válido:");
            idSeg = entrada.nextInt();
        }
        Seguradora s = seguradoras.get(idSeg);
        
        entrada.nextLine(); //para nao pular o proximo next
        return s;
    }
    
}
