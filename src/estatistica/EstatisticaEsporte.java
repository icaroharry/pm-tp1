package estatistica;

import esporte.Esporte;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EstatisticaEsporte {
    public static void gerarEstatistica(Esporte esporte) {
        try {
            FileWriter arq = new FileWriter("estatistica-1-" + esporte.getId() + ".txt");
            PrintWriter gravarArq = new PrintWriter(arq);

            gravarArq.printf("%s\n", esporte.getNome());
            for(int i=0; i < esporte.getAtletas().size(); i++) {
                gravarArq.printf("\n%-12s %.2f",
                        esporte.getAtletas().get(i).getNome(),
                        esporte.getAtletas().get(i).getResultadoIndividual());
            }

            arq.close();
        } catch(IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
    }
}
