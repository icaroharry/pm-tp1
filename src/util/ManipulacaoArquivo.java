package util;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class ManipulacaoArquivo {
    public static List<String> lerArquivo(String nome) {
        String linha;
        List<String> resultado = new ArrayList<>();

        /**
         * Leitura
         */
        try {
            // Abre o arquivo
            File arq = new File(nome);
            BufferedReader lerArq = new BufferedReader(new InputStreamReader(new FileInputStream(arq), "ISO-8859-1"));

            // Lê o arquivo
            linha = lerArq.readLine();
            while (linha != null) {
                resultado.add(linha);
                linha = lerArq.readLine();
            }

            // Fecha o arquivo
            lerArq.close();
        } catch(IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
        return resultado;
    }
}
