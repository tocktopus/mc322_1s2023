/*
 * Validacao.java
 * Ultima modificacao: 08/05/2023
 * Material usado na disciplina MC322
 */

public class Validacao{

    public static boolean validarCPF(String cpf) {
        /*
         * Recebe uma string e verifica se ela corresponde a um cpf.
         * Entrada: String cpf (cpf a ser validado)
         * Saida: valor booleano (true se o cpf for valido, false se nao for)
         */

        // removendo caracteres nao numericos
        cpf = cpf.replaceAll("\\.", "");
        cpf = cpf.replaceAll("-", "");

        // verificando se o cpf tem 11 digitos e se seus digitos nao sao todos iguais
        if (cpf.length() != 11 ||
                cpf.equals("00000000000") || cpf.equals("11111111111") ||
                cpf.equals("22222222222") || cpf.equals("33333333333") ||
                cpf.equals("44444444444") || cpf.equals("55555555555") ||
                cpf.equals("66666666666") || cpf.equals("77777777777") ||
                cpf.equals("88888888888") || cpf.equals("99999999999")) {
            return false;
        }

        char digito10, digito11;
        int soma, peso, num, r, i;

        // calculando o primeiro digito verificador:
        soma = 0;
        peso = 10;
        for (i = 0; i < 9; i++) {
            num = (int) (cpf.charAt(i) - 48);
            soma = soma + (num * peso);
            peso--;
        }

        r = 11 - (soma % 11);
        if ((r == 10) || (r == 11))
            digito10 = '0';
        else
            digito10 = (char) (r + 48);

        // calculando o segundo digito verificador:
        soma = 0;
        peso = 11;
        for (i = 0; i < 10; i++) {
            num = (int) (cpf.charAt(i) - 48);
            soma = soma + (num * peso);
            peso--;
        }

        r = 11 - (soma % 11);
        if ((r == 10) || (r == 11))
            digito11 = '0';
        else
            digito11 = (char) (r + 48);

        // verificando se os digitos calculados correspondem aos do cpf:
        if ((digito10 == cpf.charAt(9)) && (digito11 == cpf.charAt(10))) {
            return (true);
        } else {
            return (false);
        }

    }

    public static boolean validarCNPJ(String cnpj) {
        /*
         * Recebe uma string e verifica se ela corresponde a um cnpj.
         * Entrada: String cnpj (cnpj a ser validado)
         * Saida: valor booleano (true se o cnpj for valido, false se nao for)
         */

        // removendo caracteres nao numericos
        cnpj = cnpj.replaceAll("\\.", "");
        cnpj = cnpj.replaceAll("-", "");
        cnpj = cnpj.replaceAll("/", "");

        // verificando se o cnpj tem 14 digitos e se seus digitos nao sao todos iguais
        if (cnpj.length() != 14 ||
                cnpj.equals("00000000000000") || cnpj.equals("11111111111111") ||
                cnpj.equals("22222222222222") || cnpj.equals("33333333333333") ||
                cnpj.equals("44444444444444") || cnpj.equals("55555555555555") ||
                cnpj.equals("66666666666666") || cnpj.equals("77777777777777") ||
                cnpj.equals("88888888888888") || cnpj.equals("99999999999999")) {
            return false;
        }
        char digito13, digito14;
        int soma, peso, num, r, i;

        // calculando o primeiro digito verificador:
        soma = 0;
        peso = 2;
        for (i = 11; i >= 0; i--) {
            num = (int) (cnpj.charAt(i) - 48);
            soma = soma + (num * peso);
            peso++;
            if (peso == 10) {
                peso = 2;
            }
        }

        r = soma % 11;
        if ((r == 0) || (r == 1)) {
            digito13 = '0';
        } else {
            digito13 = (char) ((11 - r) + 48);
        }

        // calculando o segundo digito verificador:
        soma = 0;
        peso = 2;
        for (i = 12; i >= 0; i--) {
            num = (int) (cnpj.charAt(i) - 48);
            soma = soma + (num * peso);
            peso = peso + 1;
            if (peso == 10) {
                peso = 2;
            }

        }

        r = soma % 11;
        if ((r == 0) || (r == 1)) {
            digito14 = '0';
        } else {
            digito14 = (char) ((11 - r) + 48);
        }

        // verificando se os digitos calculados correspondem aos do cnpj:
        if ((digito13 == cnpj.charAt(12)) && (digito14 == cnpj.charAt(13))) {
            return (true);
        } else {
            return (false);
        }
    }

    public static boolean validarNome(String nome){
        /* 
         * Recebe um nome e o valida, verificando se ele possui apenas letras e espaços.
         * Entrada: String nome (nome a ser validado)
         * Saida: valor booleano (true se o nome for valido, false se nao for)
         */

        for(int i=0; i<nome.length(); i++){
            if(!Character.isLetter(nome.charAt(i)) && nome.charAt(i) != ' '){
                return false;
            }
        }
        return true;
    }
}