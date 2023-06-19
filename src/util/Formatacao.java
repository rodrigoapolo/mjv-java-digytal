package util;

public class Formatacao {

    private Formatacao() {
    }

    public static String verificaTamanho(String valor, int tamanhoFinal) {
        if (valor.length() < tamanhoFinal) {
            return adicionalEspaco(valor, tamanhoFinal);
        } else if (valor.length() > tamanhoFinal) {
            return valor.substring(0, tamanhoFinal);
        } else {
            return valor;
        }
    }

    public static String adicionalEspaco(String valor, int tamanhoFinal) {
        StringBuilder espaco = new StringBuilder();
        for (int i = valor.length(); i < tamanhoFinal; i++) {
            espaco.append(" ");
        }
        espaco.append(valor);
        return espaco.toString();
    }

    public static String verificaNumero(String numero) {
        numero = numero.replaceAll("[^0-9]", "");
        if (numero.length() != 0) {
            return numero;
        } else {
            return preecherZero(numero, 11);
        }
    }

    public static String preecherZero(String numero, int tamanhoFinal) {
        StringBuilder zero = new StringBuilder();
        for (int i = numero.length(); i < tamanhoFinal; i++) {
            zero.append("0");
        }
        zero.append(numero);
        return zero.toString();
    }
}
