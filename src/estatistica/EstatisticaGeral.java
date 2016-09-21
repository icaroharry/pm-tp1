package estatistica;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import pais.Pais;

public class EstatisticaGeral {

    /**
     * Método utilizado para gerar estatísticas gerais das olimpíadas.
     * @param List<pais> paises - lista paises participantes
     */
    public static void gerarEstatistica(List<Pais> paises) {
        try {
            gerarQuadroDeMedalhas(paises);

            // Abre o arquivo
            FileWriter arq = new FileWriter("estatistica-2.txt");
            PrintWriter gravarArq = new PrintWriter(arq);

            // Grava o arquivo
            gravarArq.printf("Quadro de medalhas\n");
            gravarArq.printf("\n%-11s %s %11s %11s", "País", "Ouro", "Prata", "Bronze");
            for(int i=0; i < paises.size(); i++) {
                gravarArq.printf("\n%-11s %d %10d %10d",
                        paises.get(i).getNome(),
                        paises.get(i).getMedalhasOuro(),
                        paises.get(i).getMedalhasPrata(),
                        paises.get(i).getMedalhasBronze());
            }

            // Fecha o arquivo
            arq.close();
        } catch(IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
    }

    /**
     * Método utilizado para ordenar a lista de países, colocando-os
     * na ordem do número de medalhas de ouro ganhas.
     *
     * Se o número de medalhas de ouro é o mesmo, utiliza-se as medalhas de prata.
     * Se o número de medalhas de prata também é o mesmo, utiliza-se as medalhas de bronze.
     * Se o número de medalhas de bronze também é o mesmo, utiliza-se a ordem alfabética
     *
     * Esse método é implementado na classe de estatísticas visto que não tem a ver com um país
     * individualmente para que seja implementado na classe País.
     */
    public static void gerarQuadroDeMedalhas(List<Pais> paises) {
        Collections.sort(paises, new Comparator<Pais>() {
            @Override
            public int compare(Pais a, Pais b) {
                if(a.getMedalhasOuro() == b.getMedalhasOuro()) {
                    if(a.getMedalhasPrata() == b.getMedalhasPrata()) {
                        if(a.getMedalhasBronze() == b.getMedalhasBronze()) {
                            return a.getNome().compareTo(b.getNome());
                        }
                        return Integer.compare(b.getMedalhasBronze(), a.getMedalhasBronze());
                    }
                    return Integer.compare(b.getMedalhasPrata(), a.getMedalhasPrata());
                }
                return Integer.compare(b.getMedalhasOuro(), a.getMedalhasOuro());
            }
        });
    }
}
