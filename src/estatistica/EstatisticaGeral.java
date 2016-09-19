package estatistica;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import tp1.Atleta;
import tp1.Pais;

public class EstatisticaGeral {
    public static void gerarEstatistica(List<Pais> paises) {
        gerarQuadroDeMedalhas(paises);
        try {
            FileWriter arq = new FileWriter("estatistica-2.txt");
            PrintWriter gravarArq = new PrintWriter(arq);

            gravarArq.printf("Quadro de medalhas\n");
            for(int i=0; i < paises.size(); i++) {
                gravarArq.printf("\n%-12s %d %10d %10d",
                        paises.get(i).getNome(),
                        paises.get(i).getMedalhasOuro(),
                        paises.get(i).getMedalhasPrata(),
                        paises.get(i).getMedalhasBronze());
            }

            arq.close();
        } catch(IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
    }

    public static void gerarQuadroDeMedalhas(List<Pais> paises) {
        // Sorting
        Collections.sort(paises, new Comparator<Pais>() {
            @Override
            public int compare(Pais a, Pais b) {
                if(a.getMedalhasOuro() == b.getMedalhasOuro()) {
                    if(a.getMedalhasPrata() == b.getMedalhasPrata()) {
                        if(a.getMedalhasBronze() == b.getMedalhasBronze()) {
                            return b.getNome().compareTo(a.getNome());
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
