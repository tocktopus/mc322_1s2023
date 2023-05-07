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
        seguradoras.add(seg);

        //adicionando veiculos a clientes
        pf.addVeiculo(v1);
        pj.addVeiculo(v2);

        //cadastrando clientes na seguradora
        System.out.println(seg.cadastrarCliente(pf));
        System.out.println(seg.cadastrarCliente(pj));

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
            case CADASTRAR:
                System.out.println("\nEscolha uma das opções digitando o número correspondente:\n"+
                                    "1.1 Cadastrar Cliente\n"+
                                    "1.2 Cadastrar Veículo\n"+
                                    "1.3 Cadastrar Seguradora\n"+
                                    "1.4 Voltar");
                MenuOperacoes opCad = MenuOperacoes.valor(entrada.nextDouble());
                
                switch(opCad){
                    case CAD_CLIENTE:
                        imprimirIDSeguradoras();
                        Seguradora s = seguradoras.get(entrada.nextInt());
                        entrada.nextLine(); //para nao pular o proximo
                        System.out.println("Tipo de cliente (pf - pessoa física, pj = pessoa jurídica): ");
                        String tipo = entrada.nextLine();

                        switch(tipo){
                            case "pf":
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

                                ClientePF cli = new ClientePF(nome, endereco, LocalDate.parse(dataLicenca), educacao, genero, classe, cpf, LocalDate.parse(dataNasc));
                                if(s.cadastrarCliente(cli)){
                                    System.out.println("Cliente cadastrado com sucesso!");
                                }else{
                                    System.out.println("Falha no cadastro, verifique se os dados estão corretos");
                                }
                            break;

                            case "pj":
                            break;

                            default:
                                System.out.println("Comando inválido");
                            break;
                        }
                    break;

                    case CAD_VEICULO:
                    break;

                    case CAD_SEG:
                    break;

                    case VOLTAR_CAD:
                        criarMenu();
                    break;

                    default:
                    break;

                }
            break;

            case LISTAR:
                System.out.println("\nEscolha uma das opções digitando o número correspondente:\n"+
                            "2.1 Listar Cliente por Seguradora\n"+
                            "2.2 Listar Sinistros por Seguradora\n"+
                            "2.3 Listar Sinistros por Cliente\n"+
                            "2.4 Listar Veiculo por Cliente\n"+
                            "2.5 Listar Veiculo por Seguradora\n"+
                            "2.6 Voltar");
                MenuOperacoes opListar = MenuOperacoes.valor(entrada.nextDouble());

                switch(opListar){
                case LISTAR_CLIENTE:
                break;

                case LISTAR_SINISTROS_SEG:
                break;

                case LISTAR_VEICULOS_CLI:
                break;

                case LISTAR_VEICULOS_SEG:
                break;

                case VOLTAR_LISTAR:
                    criarMenu();
                break;

                default:
                break;

                }

            break;

            case EXCLUIR:
            System.out.println("\nEscolha uma das opções digitando o número correspondente:\n"+
                                    "3.1 Excluir Cliente\n"+
                                    "3.2 Excluir Veículo\n"+
                                    "3.3 Excluir Sinistro\n"+
                                    "3.4 Voltar");
                MenuOperacoes opExcluir = MenuOperacoes.valor(entrada.nextDouble());
                
                switch(opExcluir){
                    case EXCLUIR_CLIENTE:
                    break;

                    case EXCLUIR_VEICULO:
                    break;

                    case EXCLUIR_SINISTRO:
                    break;

                    case VOLTAR_EXCLUIR:
                        criarMenu();
                    break;

                    default:
                    break;

                }
            break;

            case GERAR_SINISTRO:
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
            System.out.println("Nome: "+ seguradoras.get(i).getNome()+ ", ID: "+ i);
        }
    }
    
}
