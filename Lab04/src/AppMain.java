import java.time.LocalDate;
import java.util.Scanner;

public class AppMain {
    public static void main(String[] args) {
        
        Veiculo v1 = new Veiculo("AAA1234", "Fiat", "Uno", 2020);
        Veiculo v2 = new Veiculo("BBB3750", "Chevrolet", "Onix", 2013);

        ClientePF pf = new ClientePF("PF", "Avenida X", LocalDate.parse("2017-05-13"), "Ensino Medio", "M", "C", "132.104.950-17", LocalDate.parse("1990-06-30"));
        ClientePJ pj = new ClientePJ("PJ", "Rua B", "04.348.764/0001-23", LocalDate.parse("2006-01-30"), 200);

        Seguradora seg = new Seguradora("Hello World Seguros", "1140028922","hwseguros@gmail.com","Rua S n30");

        pf.addVeiculo(v1);
        pj.addVeiculo(v2);

        System.out.println(seg.cadastrarCliente(pf));
        System.out.println(seg.cadastrarCliente(pj));

        System.out.println(seg.gerarSinistro(null, null, v2, pj));
        System.out.println(seg.gerarSinistro(null, null, v1, pf));

        /*
         * to-do:
         * - Chamar os metodos da classe Seguradora: listarClientes(); visualizarSinistro(); listarSinistros(); e calcularReceita()
         * - Atualizar o atributo valorSeguro de cada cliente cadastrado na seguradora utilizando o metodo calcularPrecoSeguroCliente() 
         * da classe Seguradora;
         * - Mostrar na tela a receita total da seguradora utilizando o metodo calcularReceita();
         */

        criarMenu();
    }

    public static void criarMenu(){
        /*to-do: implementar funcionalidades*/
        Scanner entrada = new Scanner(System.in);
        System.out.println("\nBem vindo(a)!\n"+
                            "1. Cadastrar Cliente\n"+
                            "2. Listar\n"+
                            "3. Excluir\n"+
                            "4. Gerar Sinistro\n"+
                            "5. Transferir Seguro\n"+
                            "6. Calcular Receita\n"+
                            "0. Sair\n"+
                            "\nDigite o número correspondente a operação que deseja realizar:");
        
        //int operacao;
        int op = entrada.nextInt();
        
        MenuOperacoes operacao = MenuOperacoes.valor(op);
        System.out.println(operacao);
        
        switch(operacao){
            case CADASTRAR_CLIENTE:
            break;

            case LISTAR:

            break;

            case EXCLUIR:
            break;

            case GERARSINISTRO:
            break;

            case TRANSFERIRSEGURO:
            break;

            case CALCRECEITA:
            break;

            case SAIR:
            break;

            default:
            break;
        }

        entrada.close();
    }
    
}
