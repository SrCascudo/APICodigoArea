package module;

import java.util.InputMismatchException;

public class CPF_VALIDATOR {

    public static boolean isCPF(String CPF) {

        CPF = clearNumberText(CPF);

        // Verifica se e uma sequencia de numeros repetidos
        if (CPF.equals("00000000000") || CPF.equals("11111111111") || CPF.equals("22222222222")
                || CPF.equals("33333333333") || CPF.equals("44444444444") || CPF.equals("55555555555")
                || CPF.equals("66666666666") || CPF.equals("77777777777") || CPF.equals("88888888888")
                || CPF.equals("99999999999") || (CPF.length() != 11))
            return (false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - Protege o codigo para eventuais erros de conversao do tipo
        // (int)
        try {

            // Calculo do primeiro digito verificador
            sm = 0;
            peso = 10;

            for (i = 0; i < 9; i++) {

                // Converte o i-esimo caractere do CPF em um numero:
                // Por exemplo, transforma o caractere '0' no inteiro 0
                // (48 e a posicao de '0' na tabela ASCII)
                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);

            if ((r == 10) || (r == 11))
                dig10 = '0';
            else
                dig10 = (char) (r + 48); // Converte no respectivo caractere numerico

            // Calculo do segundo digito verificador
            sm = 0;
            peso = 11;

            for (i = 0; i < 10; i++) {

                num = (int) (CPF.charAt(i) - 48);
                sm = sm + (num * peso);
                peso = peso - 1;
            }

            r = 11 - (sm % 11);

            if ((r == 10) || (r == 11))
                dig11 = '0';

            else
                dig11 = (char) (r + 48);

            // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                return (true);

            else
                return (false);

        }

        catch (InputMismatchException erro) {
            return (false);
        }
    }

    public static String imprimeCPF(String CPF) {

        if (CPF == null || CPF.length() != 11)
            return "";

        return (CPF.substring(0, 3) + "." + CPF.substring(3, 6) + "." + CPF.substring(6, 9) + "-"
                + CPF.substring(9, 11));
    }

    // Limpa todos os caracteres que não são números
    public static String clearNumberText(String string) {

        if (string == null)
            return null;

        if (string.trim().equals(""))
            return "";

        return string.replaceAll("[^0-9]", "");
    }

}
