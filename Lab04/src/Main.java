import java.time.LocalDate;

public class Main {
    public static void main(String[] args){
        ClientePF pf1 = new ClientePF("PF1", "Avenida X", LocalDate.parse("2017-05-13"), "Ensino Medio", "M", "C", "132.104.950-17", LocalDate.parse("1990-06-30"));
        ClientePJ pj1 = new ClientePJ("PJ1", "Rua B", "04.348.764/0001-23", LocalDate.parse("2006-01-30"), 200);

        Veiculo v1 = new Veiculo("AAA1234", "Fiat", "Uno", 2020);
        Veiculo v2 = new Veiculo("BBB3750", "Chevrolet", "Onix", 2013);
        Veiculo v3 = new Veiculo("OMG5555", "Fiat", "Uno", 2004);
        Veiculo v4 = new Veiculo("YEE8888", "Fiat", "Palio", 2007);

        Seguradora seg = new Seguradora("Hello World Seguros", "1140028922","hwseguros@gmail.com","Rua S n30");

        pj1.addVeiculo(v1);
        pj1.addVeiculo(v2);
        pj1.addVeiculo(v3);
        pf1.addVeiculo(v4);
        System.out.println(pf1.calculaScore());
        System.out.println(pj1.calculaScore());
        seg.cadastrarCliente(pj1);
        seg.cadastrarCliente(pf1);
        System.out.println(seg.calcularPrecoSeguroCliente());
        System.out.println(Validacao.validarNome("abc de"));
        System.out.println(Validacao.validarNome("abcd2 "));
    }
}
