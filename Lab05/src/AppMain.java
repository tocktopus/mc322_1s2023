/*
 * AppMain.java
 * Ultima modificacao: 08/05/2023
 * Material usado na disciplina MC322
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

import javafx.scene.control.Menu;

public class AppMain {
    //cria lista que vai conter todas as seguradoras do programa
    private static ArrayList<Seguradora> seguradoras = new ArrayList<Seguradora>();

    public static void main(String[] args) {

        //instanciando Seguradora
        Seguradora seguradora = new Seguradora("79.382.176/0001-05", "Hello World Seguros", "12345678", "hw@gmail.com", "Avenida 1");
        seguradoras.add(seguradora);

        //instanciando e cadastrando Clientes
        ClientePF pf = new ClientePF("PF", "132.104.950-17", "999999999", "Rua A", "PF@gmail.com", "F", "Ensino Medio", LocalDate.parse("1995-05-13"));
        ClientePJ pj = new ClientePJ("PJ", "04.348.764/0001-23","12312312", "Rua B", "PF@gmail.com", LocalDate.parse("2006-01-30"), 200);
        seguradora.cadastrarCliente(pf);
        seguradora.cadastrarCliente(pj);

        //cadastrando veiculo no Cliente pf
        Veiculo v1 = new Veiculo("AAA1234", "Fiat", "Uno", 2020);
        pf.cadastrarVeiculo(v1);

        //cadastrando frota no Cliente pj ja contendo um veiculo
        Veiculo v2 = new Veiculo("BBB3750", "Chevrolet", "Onix", 2013);
        pj.cadastrarFrota(v2);

        //pegando o code da frota que criamos
        String code = pj.getListaFrota().get(0).getCode();

        //adicionando veiculo na frota
        System.out.println(pj.atualizarFrota(code, new Veiculo("AAA1234", "Fiat", "Uno", 2020)));
        //removendo veiculo da frota
        System.out.println(pj.atualizarFrota(code, "BBB3750"));
        //removendo frota
        //System.out.println(pj.atualizarFrota(code));

        //criando condutores
        Condutor c1 = new Condutor("132.104.950-17", "João", "99999-9999", "Rua A", "PF@gmail.com", LocalDate.parse("1995-05-13"));
        Condutor c2 = new Condutor("799.634.220-20", "Maria", "91234-5678", "Rua F", "maria@gmail.com", LocalDate.parse("1985-02-24"));

        
        //gerando seguros PF e PJ
        System.out.println(seguradora.gerarSeguro(new SeguroPF(LocalDate.parse("2023-05-13"), LocalDate.parse("2024-12-12"), seguradora, pf.getListaVeiculos().get(0), pf)));
        System.out.println(seguradora.gerarSeguro(new SeguroPJ(LocalDate.parse("2023-07-20"), LocalDate.parse("2024-10-11"), seguradora, pj.getListaFrota().get(0), pj)));
        
        //autorizando condutores para cada um dos seguros
        System.out.println(seguradora.listarSeguros().get(0).autorizarCondutor(c1));
        System.out.println(seguradora.listarSeguros().get(1).autorizarCondutor(c2));

        //gerando sinistros para cada um dos seguros
        System.out.println(seguradora.listarSeguros().get(0).gerarSinistro(new Sinistro(LocalDate.parse("2023-05-24"), "Centro", seguradora.listarSeguros().get(0), c1)));
        System.out.println(seguradora.listarSeguros().get(1).gerarSinistro(new Sinistro(LocalDate.parse("2023-05-24"), "Rua X", seguradora.listarSeguros().get(1), c2)));
        
        /*COISAS FALTANDO: 
         * Apresentar os detalhes de pelo menos 1 objeto de cada classe com o respectivo Metodo ToString().
         * Apresentar exemplos da utilizacao dos principais métodos das classes do Sistema de Seguradora.
         * Chamar o menu
        */

        /*System.out.println(seguradora.listarClientes());
        System.out.println("SEGUROS POR CLIENTE\n"+seguradora.getSegurosPorCliente("04.348.764/0001-23"));
        System.out.println("SINISTROS POR CLIENTE\n"+seguradora.getSinistrosPorCliente("04.348.764/0001-23"));
        System.out.println(pf);*/
        /*if(seguradora.getSegurosPorCliente("132.105.950-17").isEmpty()){
            System.out.println("cliente nao encontrado ou nao possui seguros");
        }*/
        seguradora.calcularReceita();

        //finalmente, criando o menu interativo*/
        criarMenu();
        //System.out.println(((ClientePF)seguradora.listarClientes().get(0)).getListaVeiculos());
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
                                "9 Atualizar Frota\n"+
                                "10 Calcular Receita\n"+
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
                            imprimirIDSeguradoras();
                            Seguradora s = seguradoras.get(entrada.nextInt());
                            entrada.nextLine(); //para nao pular o proximo next

                            System.out.println("Insira o tipo de cliente (digite \"pf\" para pessoa física, \"pj\" para pessoa jurídica): ");
                            String tipo = entrada.nextLine();
                            switch(tipo){
                                case "pf":{
                                    System.out.println("Nome: ");
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
                                        System.out.println("Falha no cadastro, verifique se os dados estão corretos");
                                    }
                                }break;

                                case "pj":{
                                    System.out.println("Nome: ");
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
                                        System.out.println("Falha no cadastro, verifique se os dados estão corretos");
                                    }
                                }break;

                                default:
                                    System.out.println("Comando inválido");
                                break;
                            }
                        }break;

                        case CAD_VEICULO:{
                            imprimirIDSeguradoras();
                            Seguradora s = seguradoras.get(entrada.nextInt());
                            entrada.nextLine(); //para nao pular o proximo

                            System.out.println("Insira o cpf/cnpj do cliente ao qual será cadastrado o veículo:");
                            String cliente = entrada.nextLine();
                            Cliente c = s.encontrarCliente(cliente);
                            if (c == null) {
                                System.out.println("Cliente inválido");
                            }else if(c instanceof ClientePF){
                                ClientePF k = (ClientePF)c; //faz o downcasting
                                        System.out.println("Placa: ");
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
                                System.out.println("Frotas de cliente " + cliente + ":\n" + k.getListaFrota() + "\nCódigo da frota à qual será cadastrado o veículo: ");
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
                                    System.out.println("Cliente cadastrado com sucesso!");
                                }else{
                                    System.out.println("Falha no cadastro, verifique se o código está correto.");
                                }
                            }

                        }break;
 
                        case CAD_SEGURADORA:{

                            entrada.nextLine(); //para nao pular o proximo
                            System.out.println("Nome da nova seguradora:");
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
                            imprimirIDSeguradoras();
                            Seguradora s = seguradoras.get(entrada.nextInt());

                            entrada.nextLine(); //para nao pular o proximo
                            System.out.println("Insira o tipo de cliente (digite \"pf\" para pessoa física, \"pj\" para pessoa jurídica): ");
                            String tipo = entrada.nextLine();
                            
                            if(tipo.equals("pf") || tipo.equals("pj")){
                                System.out.println("Listando clientes "+tipo+" da Seguradora "+s.getNome() + ":\n" + s.listarClientes(tipo));
                            }else{
                                System.out.println("Comando inválido");
                            }
                        }break;

                        case LISTAR_SEGURO:{
                            imprimirIDSeguradoras();
                            Seguradora s = seguradoras.get(entrada.nextInt());

                            entrada.nextLine(); //para nao pular o proximo
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
                                    System.out.println("Comando inválido");
                                break;
                            }
                        }break;

                        case LISTAR_SINISTROS:{
                            imprimirIDSeguradoras();
                            Seguradora s = seguradoras.get(entrada.nextInt());

                            entrada.nextLine(); //para nao pular o proximo
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
                                    System.out.println("Comando inválido");
                                break;
                            }
                        }break;

                        case LISTAR_CONDUTORES:{
                            imprimirIDSeguradoras();
                            Seguradora s = seguradoras.get(entrada.nextInt());
                            entrada.nextLine(); //para nao pular o proximo

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
                            imprimirIDSeguradoras();
                            Seguradora s = seguradoras.get(entrada.nextInt());
                            entrada.nextLine(); //para nao pular o proximo
                            System.out.println("Insira o cnpj do cliente cujas Frotas deseja listar");

                            String cliente = entrada.nextLine();
                            Cliente c = s.encontrarCliente(cliente);
                            if (c != null && c instanceof ClientePJ) {
                                ClientePJ k = (ClientePJ)c;
                                System.out.println("Listando Frotas do Cliente "+ cliente + ":\n" +k.getListaFrota());
                            }else{
                                System.out.println("Cliente inválido");
                            }

                        }break;

                        case LISTAR_VEICULOS:{
                            imprimirIDSeguradoras();
                            Seguradora s = seguradoras.get(entrada.nextInt());
                            entrada.nextLine(); //para nao pular o proximo

                            System.out.println("Insira o cpf do cliente cujos Veículos deseja listar:");
                            String cliente = entrada.nextLine();
                            Cliente c = s.encontrarCliente(cliente);

                            if (c != null && c instanceof ClientePF) {
                                ClientePF k = (ClientePF)c;
                                System.out.println("Listando Veiculos do Cliente "+ cliente + ":\n" +k.getListaVeiculos());
                            }else{
                                System.out.println("Cliente inválido");
                            }
                        }break;

                        case VOLTAR_LISTAR:
                            continue loop;

                        default:
                            System.out.println("Operação inválida");
                        break;

                    }

                }break;
 
                case EXCLUIR:{
                System.out.println("\n ----EXCLUIR----\nEscolha uma das opções digitando o número correspondente:\n"+
                                        "3.1 Excluir Cliente\n"+
                                        "3.2 Excluir Veículo\n"+
                                        "3.4 Voltar");
                    MenuOperacoes opExcluir = MenuOperacoes.valor(entrada.nextDouble());
                    
                    switch(opExcluir){
                        case EXCLUIR_CLIENTE:{
                            imprimirIDSeguradoras();
                            Seguradora s = seguradoras.get(entrada.nextInt());
                            entrada.nextLine(); //para nao pular o proximo

                            System.out.println("Insira o cpf/cnpj do cliente que deseja excluir:");
                            String cliente = entrada.nextLine();
                            if(s.removerCliente(cliente)){
                                System.out.println("Cliente removido com sucesso");
                                
                            }else{
                                System.out.println("Cliente não encontrado");
                            }
                        }break;

                        /*case EXCLUIR_VEICULO:{
                            imprimirIDSeguradoras();
                            Seguradora s = seguradoras.get(entrada.nextInt());
                            entrada.nextLine();//para nao pular o proximo

                            System.out.println("Insira a placa do veículo a ser removido:");
                            String placa = entrada.nextLine();
                            if(s.excluirVeiculoCliente(placa)){
                                System.out.println("Veiculo excluido com sucesso");
                            }else{
                                System.out.println("Veiculo não encontrado");
                            }
                        }break;*/

                        case VOLTAR_EXCLUIR:
                            continue loop;

                        default:
                            System.out.println("Operação inválida");
                        break;

                    }
                }break;

/*                 case GERAR_SINISTRO:{
                    imprimirIDSeguradoras();
                    Seguradora s = seguradoras.get(entrada.nextInt());
                    entrada.nextLine();//para nao pular o proximo

                    System.out.println("Insira o cpf/cnpj do cliente para o qual será gerado o sinistro");
                    String cliente = entrada.nextLine();
                    Cliente c = s.encontrarCliente(cliente);

                    if (c == null) {
                        System.out.println("Cliente não encontrado.");
                    }else{
                        System.out.println("Digite a placa do veículo associado:");
                        String placa = entrada.nextLine();
                        Veiculo veicSinistro = null;
                        for(Veiculo v : c.getListaVeiculos()){
                            if (v.getPlaca().equals(placa)){
                                veicSinistro = v;
                                break;
                            }
                        }
                        if(veicSinistro == null){
                            System.out.println("Veículo não encontrado");
                        }else{
                            System.out.println("Data de ocorrência do sinistro (formato aaaa-mm-dd):");
                            String data = entrada.nextLine();
                            System.out.println("Local do sinistro: ");
                            String endereco = entrada.nextLine();

                            s.gerarSinistro(LocalDate.parse(data), endereco, veicSinistro, c);
                            s.calcularPrecoSeguroCliente();
                            System.out.println("Sinistro gerado com sucesso. Valor do seguro agora é: "+c.getValorSeguro());
                        }
                    }
                            
                }break;

                case TRANSFERIR_SEGURO:{
                    imprimirIDSeguradoras();
                    Seguradora s = seguradoras.get(entrada.nextInt());
                    entrada.nextLine();//para nao pular o proximo

                    System.out.println("Insira o cpf/cnpj do primeiro cliente da transferência: ");
                    String cliente1 = entrada.nextLine();
                    System.out.println("Insira o cpf/cnpj do segundo cliente: ");
                    String cliente2 = entrada.nextLine();
                    
                    if(!s.transferirSeguro(cliente1, cliente2)){
                        System.out.println("Transferência não concluída. Clientes inválidos.");
                    }

                }break;

                case CALC_RECEITA:{
                    imprimirIDSeguradoras();
                    Seguradora s = seguradoras.get(entrada.nextInt());
                    s.calcularPrecoSeguroCliente();
                    System.out.println("A receita total da seguradora "+s.getNome()+" é de "+s.calcularReceita());
                }break;
*/
                case SAIR:
                    System.out.println("Saindo...");
                    break loop;

                default:
                    System.out.println("Operação inválida");
                break;
            }
        }
        entrada.close();
    }

    public static void imprimirIDSeguradoras(){
        //Imprime todas as seguradoras existentes e seus respectivos ids
        System.out.println("Escolha uma das seguradoras digitando seu id:");
        for (int i=0; i < seguradoras.size(); i++){
            System.out.println("ID "+ i + " - "+ seguradoras.get(i).getNome());
        }
    }
    
}
