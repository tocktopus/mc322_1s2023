import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        //TO-DO: deixar main nos conformes das instrucoes, por enquanto estamos usando apenas para testes rapidos

        // Criando objeto da classe Seguradora
        Seguradora seg = new Seguradora("Hello World Seguros", "1140028922","hwseguros@gmail.com","Rua S n30");

        // Criando objetos da classe ClientePJ e ClientePF
        ClientePJ pj1 = new ClientePJ("PJ1", "Rua B", LocalDate.parse("2007-01-08"), "04.348.764/0001-23", LocalDate.parse("2006-01-30"));
        ClientePJ pj2 = new ClientePJ("PJ2", "Rua C", LocalDate.parse("2015-12-02"), "12.445.351/0001-95", LocalDate.parse("2012-03-22"));
        ClientePF pf1 = new ClientePF("PF1", "Avenida X", LocalDate.parse("2017-05-13"), "Ensino Medio", "M", "C", "132.104.950-17", LocalDate.parse("1990-06-18"));
        ClientePF pf2 = new ClientePF("PF2", "Avenida Y", LocalDate.parse("2022-12-24"), "Ensino Superior", "F", "C", "436.370.260-58", LocalDate.parse("1980-10-07"));

        // Criando objetos da classe Veiculo
        Veiculo v1 = new Veiculo("AAA1234", "Fiat", "Uno", 2020);
        Veiculo v2 = new Veiculo("BBB3750", "Chevrolet", "Onix", 2013);
        Veiculo v3 = new Veiculo("OMG5555", "Fiat", "Uno", 2004);
        Veiculo v4 = new Veiculo("YEE8888", "Fiat", "Palio", 2007);

        // Associando Veiculos a Clientes
        pj1.addVeiculo(v1);
        pj2.addVeiculo(v2);
        pf1.addVeiculo(v3);
        pf2.addVeiculo(v4);

        // Cadastrando Clientes
        seg.cadastrarCliente(pj1);
        seg.cadastrarCliente(pj2);
        seg.cadastrarCliente(pf1);
        seg.cadastrarCliente(pf2);

        // Removendo Cliente PJ2
        seg.removerCliente("12.445.351/0001-95");

        // Gerando Sinistros
        seg.gerarSinistro(LocalDate.parse("2008-01-15"), "Rua 1",  v1, pj1);
        seg.gerarSinistro(LocalDate.parse("2017-12-08"), "Rua 2", v2, pj1);
        seg.gerarSinistro(LocalDate.parse("2019-11-19"), "Rua 3", v3, pf1);
        seg.gerarSinistro(LocalDate.parse("2020-07-20"), "Rua 4", v4, pf1);

        // Menu textual para visualizar dados da seguradora
        System.out.println("-------------------------- Seguradora "+seg.getNome()+" --------------------------");
        System.out.println("\nBem vindo! O que deseja fazer?\n"+
                            "1. Visualizar os dados da Seguradora\n"+
                            "2. Listar clientes da seguradora\n"+
                            "3. Listar todos os sinistros\n"+
                            "4. Listar sinistros de um cliente específico\n"+
                            "5. Validar um CPF\n"+
                            "6. Validar um CNPJ\n"+
                            "\nDigite o número correspondente ao que deseja fazer:");
        
        // Metodo scanner para leitura de dados
        Scanner entrada = new Scanner(System.in);
        int opc;
        opc = entrada.nextInt();
        switch(opc){
            case 1:
                System.out.println("\nDados da Seguradora\n"+seg);
                break;
            case 2:
                System.out.println("Qual tipo de cliente deseja listar?\n1. Listar pessoas físicas\n2. Listar pessoas jurídicas");
                int opcCliente = entrada.nextInt();
                switch(opcCliente){
                    case 1:
                        System.out.println("\nListando pessoas físicas:\n"+seg.listarClientes("pf"));
                        break;
                    case 2:
                        System.out.println("\nListando pessoas jurídicas:\n"+seg.listarClientes("pj"));
                        break;
                    default:
                        System.out.println("Opção Inválida");
                }
                break;
            case 3:
                System.out.println("\nListando sinistros:\n"+seg.listarSinistros());
                break;
            case 4:
                System.out.println("Insira o CPF ou CNPJ do cliente cujos sinistros deseja acessar: ");
                String cliente = entrada.next();
                System.out.println("\n");
                if(!seg.visualizarSinistro(cliente)){
                    System.out.println("Esse cliente não foi cadastrado ou não há sinistros associados a ele.");
                }
                break;
            case 5:
                System.out.println("Insira o CPF a ser validado: ");
                String cpf = entrada.next();
                System.out.println(ClientePF.validarCPF(cpf) ? "CPF válido" : "CPF inválido"); 
                break;
            case 6:
                System.out.println("Insira o CNPJ a ser validado: ");
                String cnpj = entrada.next();
                System.out.println(ClientePJ.validarCNPJ(cnpj) ? "CNPJ válido" : "CNPJ inválido"); 
                break;
            default:
                System.out.println("Opção inválida");
        }

        entrada.close();
    }

}


