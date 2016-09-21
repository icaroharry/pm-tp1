package estatistica;

import esporte.Esporte;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EstatisticaEsporte {

    /**
     * Método utilizado para gerar estatísticas individuais
     * de vencedores de cada esporte.
     * @param esporte - objeto do esporte do qual serão geradas as estatísticas
     */
    public static void gerarEstatistica(Esporte esporte) {
        try {
            // Abre arquivo
            FileWriter arq = new FileWriter("estatistica-1-" + esporte.getId() + ".txt");
            PrintWriter gravarArq = new PrintWriter(arq);

            // Grava arquivo
            gravarArq.printf("%s\n", esporte.getNome());
            for(int i=0; i < esporte.getAtletas().size(); i++) {
                if (esporte.getNome() == "Levantamento de peso") {
                    gravarArq.printf("\n%-11s %d",
                            esporte.getAtletas().get(i).getNome(),
                            (int)esporte.getAtletas().get(i).getResultadoIndividual());
                } else {
                    gravarArq.printf("\n%-11s %.2f",
                            esporte.getAtletas().get(i).getNome(),
                            esporte.getAtletas().get(i).getResultadoIndividual());
                }

            }

            // Fecha arquivo
            arq.close();
        } catch(IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
        }
    }
}
