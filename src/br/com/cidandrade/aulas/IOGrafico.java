package br.com.cidandrade.aulas;

import javax.swing.JOptionPane;

/**
 *
 * @author cidandrade
 */
public class IOGrafico {
    
//    alteracoes feitas por mim (raphael sousa) passei os atributos para a classe 
//    como estáticos para que fosse possível utilizá-los fora do método modoGrafico()
    private static String nome;
    private static byte idade;
    private static float altura;

    public static String getNome() {
        return nome;
    }

    public static byte getIdade() {
        return idade;
    }

    public static float getAltura() {
        return altura;
    }

    public static void modoGrafico() {

        nome = entradaString("Digite seu nome");
        try {
            if (!nome.equals("")) {
                try {
                    String aux;
                    aux = entradaString("E qual é a sua idade, "
                            + nome + "?");
                    idade = Byte.parseByte(aux);
                    Mensagem.mensagemBasica(idade + " anos é uma boa idade");
                    aux = entradaString("Qual é a sua altura?");
                    altura = Float.parseFloat(
                            aux.replace(",", "."));
                    Mensagem.mensagemDeInformacao(String.format(
                            "%.2f m de altura!!! Legal.",
                            altura), "Uau!!");
                } catch (NumberFormatException e) {
                    Mensagem.mensagemDeErro("Ocorreu problema na "
                            + "conversão da entrada");
                }
            } else {
                Mensagem.mensagemBasica("Não quer conversar? Tudo bem!");
            }
        } catch (NullPointerException e) {
            Mensagem.mensagemBasica("Não quer conversar? Tudo bem!");
        }
    }

    private static String entradaString(String msg) {
        return JOptionPane.showInputDialog(null, msg);
    }
}
