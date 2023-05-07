import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class AppMain {
    private static ArrayList<Seguradora> seguradoras = new ArrayList<Seguradora>();

    public static void main(String[] args) {
        //cria lista de seguradoras

        //instanciando veiculos, clientes e seguradora
        Veiculo v1 = new Veiculo("AAA1234", "Fiat", "Uno", 2020);
        Veiculo v2 = new Veiculo("BBB3750", "Chevrolet", "Onix", 2013);

        ClientePF pf = new ClientePF("PF", "Avenida X", LocalDate.parse("2017-05-13"), "Ensino Medio", "M", "C", "132.104.950-17", LocalDate.parse("1990-06-30"));
        ClientePJ pj = new ClientePJ("PJ", "Rua B", "04.348.764/0001-23", LocalDate.parse("2006-01-30"), 200);

        Seguradora seg = new Seguradora("Hello World Seguros", "1140028922","hwseguros@gmail.com","Rua S n30");


        Seguradora seg2 = new Seguradora("a", "1140028922","hwseguros@gmail.com","Rua S n30");
        ClientePJ pj2 = new ClientePJ("PJ", "Rua B", "50.372.210/0001-89", LocalDate.parse("2006-01-30"), 200);
        seg2.cadastrarCliente(pj2);

        seguradoras.add(seg);
        seguradoras.add(seg2);
        pj2.addVeiculo(v2);
        seg2.gerarSinistro(null, null, v2, pj2);

        //adicionando veiculos a clientes
        pf.addVeiculo(v1);
        pj.addVeiculo(v2);

        //cadastrando clientes na seguradora
        System.out.println(seg.cadastrarCliente(pf));
        System.out.println(seg.cadastrarCliente(pj));
        seg.calcularPrecoSeguroCliente();

        //gerando sinistros
        System.out.println(seg.gerarSinistro(null, null, v2, pj));
        System.out.println(seg.gerarSinistro(null, null, v1, pf));

        /*
         * to-do:
         * - Chamar os metodos da classe Seguradora: listarClientes(); visualizarSinistro(); listarSinistros(); e calcularReceita()
         * - Atualizar o atributo valorSeguro de cada cliente cadastrado na seguradora utilizando o metodo calcularPrecoSeguroCliente() 
         * da classe Seguradora;
         * - Mostrar na tela a receita total da seguradora utilizando o metodo calcularReceita();
         */

         
        seg.calcularPrecoSeguroCliente();
        System.out.println(pj.getValorSeguro());
        
        System.out.println(seg.calcularReceita());

        criarMenu();
    }

    public static void criarMenu(){
        Scanner entrada = new Scanner(System.in);
        entrada.useLocale(Locale.ENGLISH); //para aceitar valores double usando ponto ao invés de vírgula
        /*to-do: implementar funcionalidades*/

        System.out.println("\nBem vindo(a)! Escolha uma das opções digitando o número correspondente:\n"+
                            "1 Cadastrar\n"+
                            "2 Listar\n"+
                            "3 Excluir\n"+
                            "4 Gerar Sinistro\n"+
                            "5 Transferir Seguro\n"+
                            "6 Calcular Receita da Seguradora\n"+
                            "0 Sair");

        MenuOperacoes operacao = MenuOperacoes.valor(entrada.nextDouble());
        
        switch(operacao){
            case CADASTRAR:{
                System.out.println("\nEscolha uma das opções digitando o número correspondente:\n"+
                                    "1.1 Cadastrar Cliente\n"+
                                    "1.2 Cadastrar Veículo\n"+
                                    "1.3 Cadastrar Seguradora\n"+
                                    "1.4 Voltar");
                MenuOperacoes opCad = MenuOperacoes.valor(entrada.nextDouble());
                
                switch(opCad){
                    case CAD_CLIENTE:{
                        imprimirIDSeguradoras();
                        Seguradora s = seguradoras.get(entrada.nextInt());
                        entrada.nextLine(); //para nao pular o proximo

                        System.out.println("Insira o tipo de cliente (digite \"pf\" para pessoa física, \"pj\" para pessoa jurídica): ");
                        String tipo = entrada.nextLine();
                        switch(tipo){
                            case "pf":{
                                System.out.println("Nome: ");
                                String nome = entrada.nextLine();
                                System.out.println("CPF: ");
                                String cpf = entrada.nextLine();
                                System.out.println("Data de nascimento (formato aaaa-mm-dd): ");
                                String dataNasc = entrada.nextLine();
                                System.out.println("Endereço: ");
                                String endereco = entrada.nextLine();
                                System.out.println("Educação: ");
                                String educacao = entrada.nextLine();
                                System.out.println("Gênero: ");
                                String genero = entrada.nextLine();
                                System.out.println("Data licença (formato aaaa-mm-dd): ");
                                String dataLicenca = entrada.nextLine();
                                System.out.println("Classe econômica: ");
                                String classe = entrada.nextLine();

                                ClientePF clientePF = new ClientePF(nome, endereco, LocalDate.parse(dataLicenca), educacao, genero, classe, cpf, LocalDate.parse(dataNasc));
                                s.cadastrarCliente(clientePF);
                                if(s.cadastrarCliente(clientePF)){
                                    System.out.println("Cliente cadastrado com sucesso!");
                                    s.calcularPrecoSeguroCliente();
                                    System.out.println("Valor do seguro: "+clientePF.getValorSeguro());
                                }else{
                                    System.out.println("Falha no cadastro, verifique se os dados estão corretos");
                                }
                            }break;

                            case "pj":{
                                System.out.println("Nome: ");
                                String nomeEmpresa = entrada.nextLine();
                                System.out.println("CNPJ: ");
                                String cnpj = entrada.nextLine();
                                System.out.println("Endereço: ");
                                String endEmpresa = entrada.nextLine();
                                System.out.println("Data de fundação (formato aaaa-mm-dd): ");
                                String dataFund = entrada.nextLine();
                                System.out.println("Quantidade de funcionários: ");
                                int qtdFunc = entrada.nextInt();

                                ClientePJ clientePJ = new ClientePJ(nomeEmpresa, endEmpresa, cnpj, LocalDate.parse(dataFund), qtdFunc);
                                if(s.cadastrarCliente(clientePJ)){
                                    System.out.println("Cliente cadastrado com sucesso!");
                                    s.calcularPrecoSeguroCliente();
                                    System.out.println("Valor do seguro: "+clientePJ.getValorSeguro());
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

                        System.out.println("Insira o tipo de cliente ao qual o veículo será cadastrado (digite \"pf\" para pessoa física, \"pj\" para pessoa jurídica): ");
                        String tipo = entrada.nextLine();
                        Cliente c = null;
                        switch(tipo){
                            case "pf":{
                                System.out.println("Digite o CPF do cliente");
                                String cpf = entrada.nextLine();
                                c = s.encontrarClientePF(cpf);
                            }break;
                            case "pj":{
                                System.out.println("Digite o CPF do cliente");
                                String cnpj = entrada.nextLine();
                                c = s.encontrarClientePJ(cnpj);
                            }break;
                            default:
                                System.out.println("Comando inválido");
                            break;
                        }
                        if (c == null) {
                            System.out.println("Cliente inválido");
                        }else{
                            System.out.println("Placa: ");
                            String placa = entrada.nextLine();
                            System.out.println("Marca: ");
                            String marca = entrada.nextLine();
                            System.out.println("Modelo: ");
                            String modelo = entrada.nextLine();
                            System.out.println("Ano de fabricação: ");
                            int ano = entrada.nextInt();
                            Veiculo v = new Veiculo(placa, marca, modelo, ano);
                            c.addVeiculo(v);
                            s.calcularPrecoSeguroCliente();
                            System.out.println("O valor do seguro do cliente "+c.getNome()+" agora é: "+c.getValorSeguro());
                        }

                    }break;

                    case CAD_SEGURADORA:{

                        entrada.nextLine(); //para nao pular o proximo
                        System.out.println("Nome da nova seguradora:");
                        String nome = entrada.nextLine();
                        System.out.println("Telefone: ");
                        String telefone = entrada.nextLine();
                        System.out.println("Email: ");
                        String email = entrada.nextLine();
                        System.out.println("Endereço: ");
                        String endereco = entrada.nextLine();

                        Seguradora seg = new Seguradora(nome, telefone, email, endereco);
                        seguradoras.add(seg);
                        //imprimirIDSeguradoras();
                    }break;

                    case VOLTAR_CAD:
                        criarMenu();
                    break;

                    default:
                        System.out.println("Operação inválida");
                    break;

                }
            }break;

            case LISTAR:{
                System.out.println("\nEscolha uma das opções digitando o número correspondente:\n"+
                            "2.1 Listar Cliente por Seguradora\n"+
                            "2.2 Listar Sinistros por Seguradora\n"+
                            "2.3 Listar Sinistros por Cliente\n"+
                            "2.4 Listar Veiculo por Cliente\n"+
                            "2.5 Listar Veiculo por Seguradora\n"+
                            "2.6 Voltar");
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

                    case LISTAR_SINISTROS_SEG:{
                        imprimirIDSeguradoras();
                        Seguradora s = seguradoras.get(entrada.nextInt());
                        System.out.println(s.listarSinistros());
                    }break;

                    case LISTAR_SINISTROS_CLI:{
                        imprimirIDSeguradoras();
                        Seguradora s = seguradoras.get(entrada.nextInt());
                        entrada.nextLine(); //para nao pular o proximo

                        System.out.println("Insira o cpf/cnpj do cliente cujos sinistros deseja listar");
                        String cliente = entrada.nextLine();
                        if(!s.visualizarSinistro(cliente)){
                            System.out.println("Esse cliente não foi cadastrado ou não há sinistros associados a ele.");
                        }
                    }break;

                    case LISTAR_VEICULOS_CLI:{
                        imprimirIDSeguradoras();
                        Seguradora s = seguradoras.get(entrada.nextInt());
                        entrada.nextLine(); //para nao pular o proximo

                        System.out.println("Insira o tipo de cliente ao qual o veículo será cadastrado (digite \"pf\" para pessoa física, \"pj\" para pessoa jurídica): ");
                        String tipo = entrada.nextLine();
                        Cliente c = null;
                        switch(tipo){
                            case "pf":{
                                System.out.println("Digite o CPF do cliente");
                                String cpf = entrada.nextLine();
                                c = s.encontrarClientePF(cpf);
                            }break;
                            case "pj":{
                                System.out.println("Digite o CNPJ do cliente");
                                String cnpj = entrada.nextLine();
                                c = s.encontrarClientePJ(cnpj);
                            }break;
                            default:
                                System.out.println("Comando inválido");
                            break;
                        }
                        if (c != null) {
                            System.out.println(c.getListaVeiculos());
                        }else{
                            System.out.println("Cliente inválido");
                        }
                    }break;

                    case LISTAR_VEICULOS_SEG:{
                        imprimirIDSeguradoras();
                        Seguradora s = seguradoras.get(entrada.nextInt());
                        System.out.println("Imprimindo veículos da da Seguradora "+s.getNome()+"\n"+s.listarVeiculosClientes());
                    }break;

                    case VOLTAR_LISTAR:
                        criarMenu();
                    break;

                    default:
                        System.out.println("Operação inválida");
                    break;

                }

            }break;

            case EXCLUIR:
            System.out.println("\nEscolha uma das opções digitando o número correspondente:\n"+
                                    "3.1 Excluir Cliente\n"+
                                    "3.2 Excluir Veículo\n"+
                                    "3.3 Excluir Sinistro\n"+
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

                    case EXCLUIR_VEICULO:{
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
                    }break;

                    case EXCLUIR_SINISTRO:{
                        imprimirIDSeguradoras();
                        Seguradora s = seguradoras.get(entrada.nextInt());
                        System.out.println("Insira o ID do sinistro a ser removido:");
                        int id = entrada.nextInt();
                        if(s.excluirSinistro(id)){
                            System.out.println("Sinistro excluído com sucesso");
                        }else{
                            System.out.println("Sinistro não encontrado para essa seguradora");
                        }
                        
                
                    }break;

                    case VOLTAR_EXCLUIR:
                        criarMenu();
                    break;

                    default:
                        System.out.println("Operação inválida");
                    break;

                }
            break;

            case GERAR_SINISTRO:
                imprimirIDSeguradoras();
                Seguradora s = seguradoras.get(entrada.nextInt());
                entrada.nextLine();//para nao pular o proximo

                System.out.println("Insira o tipo de cliente para o qual será gerado o Sinistro (digite \"pf\" para pessoa física, \"pj\" para pessoa jurídica): ");
                String tipo = entrada.nextLine();
                Cliente c = null;
                switch(tipo){
                    case "pf":{
                        System.out.println("Digite o CPF do cliente");
                        String cpf = entrada.nextLine();
                        c = s.encontrarClientePF(cpf);
                    }break;
                    case "pj":{
                        System.out.println("Digite o CPF do cliente");
                        String cnpj = entrada.nextLine();
                        c = s.encontrarClientePJ(cnpj);
                    }break;
                    default:
                        System.out.println("Comando inválido");
                    break;
                }if (c == null) {
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
                        System.out.println(s.listarSinistros());
                    }
                    
                    
                }
                        
            break;

            case TRANSFERIR_SEGURO:
            break;

            case CALC_RECEITA:
            break;

            case SAIR:
            break;

            default:
            break;
        }
        entrada.close();
    }

    public static void imprimirIDSeguradoras(){
        System.err.println("Escolha uma das seguradoras digitando seu id:");
        for (int i=0; i < seguradoras.size(); i++){
            System.out.println("ID "+ i + " - "+ seguradoras.get(i).getNome());
        }
    }
    
}
