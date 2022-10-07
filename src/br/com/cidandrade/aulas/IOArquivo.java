package br.com.cidandrade.aulas;

import java.awt.Desktop;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author cidandrade
 */
public class IOArquivo {
    
    static String nomeArquivo;
    static File arquivo;
    
    public static void modoArquivo(String nomeASerInserido, Byte idadeASerInserida, Float alturaASerInserida) {
        nomeArquivo = "testeJava.txt";
        arquivo = new File(nomeArquivo);
        try {
            arquivo.createNewFile();
            try ( FileWriter fw = new FileWriter(arquivo, false)) {
                fw.write(nomeASerInserido + "\n");
                fw.write(idadeASerInserida + "\n");
                fw.write(alturaASerInserida + "\n");
            }
            try ( Scanner sc = new Scanner(arquivo)) {
                String nome = sc.nextLine();
                byte idade = Byte.parseByte(sc.nextLine());
                float altura = Float.parseFloat(sc.nextLine());
                Mensagem.mensagemBasica(String.format(
                        "Prazer, %s, de %d anos de idade e "
                        + "%.2f de altura",
                        nome, idade, altura));
            }
        } catch (IOException ex) {
            Mensagem.mensagemDeErro("Erro na criação do arquivo " + ex.getLocalizedMessage());
        }
    }
    
    public static void abrirArquivo() {
        if (!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not  
        {
            Mensagem.mensagemDeErro("Não suportado pela plataforma");
        }
        try {
            Desktop desktop = Desktop.getDesktop();
            if (arquivo.exists()) {
                desktop.open(arquivo);
            } else {
                Mensagem.mensagemDeErro("Arquivo não existente");
            }
            
        } catch (IOException e) {
            Mensagem.mensagemDeErro(e.getLocalizedMessage());
        }
    }
}
