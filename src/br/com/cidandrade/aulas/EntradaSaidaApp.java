package br.com.cidandrade.aulas;

/**
 *
 * @author cidandrade
 */
public class EntradaSaidaApp {

    public static void main(String[] args) {
//        Aqui temos diferentes formas de receber input do usuario, seja por texto
//        através do prompt de comando ou interface grafica com o JOptionPane
//        Após rodar o modo texto, é possivel que a janela do modo gráfico abra 
//        em segundo plano, verifique se não está aberta minimizando sua IDE
        IOTexto.modoTexto();
        IOGrafico.modoGrafico();

//        Aqui crio um arquivo com as informações recebidas pelo modo gráfico
        Mensagem.mensagemBasica("Criando arquivo...");
        IOArquivo.modoArquivo(IOGrafico.getNome(), IOGrafico.getIdade(),
                IOGrafico.getAltura());
//      Metodo criado por mim (raphael sousa) para abrir o arquivo ao ser criado
        IOArquivo.abrirArquivo();
        System.exit(0);
    }

}
