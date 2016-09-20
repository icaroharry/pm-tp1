package esporte;

import atleta.Atleta;

import java.util.Collections;
import java.util.Comparator;

public class GinasticaArtistica extends Esporte {
    // Construtores
    public GinasticaArtistica() {
        super();
    }

    public GinasticaArtistica(int id, String nome) {
        super(id, nome);
    }

    public GinasticaArtistica(int id) {
        super(id);
        this.setNome("Ginástica artística");
    }

    // Métodos

    /**
     * Sobrescrita do método calculaResultadoIndividual
     * No caso da ginástica, o resultado individual é calculado pela média de notas dadas por 4 juízes
     */
    @Override
    protected double calculaResultadoIndividual(double[] result) {
        double media = 0;
        for(int i = 0; i < 4; i++) {
            media += result[i];
        }
        return media/4;
    }

    /**
     * Sobrescrita do método determinaVencedor
     * No caso da ginástica, é feito uma ordenação de forma decrescente (do maior para o menor tempo)
     * na lista de atletas.
     */
    @Override
    public void determinaVencedor() {
        Collections.sort(atletas, new Comparator<Atleta>() {
            @Override
            public int compare(Atleta a, Atleta b) {
                if(a.getResultadoIndividual() == b.getResultadoIndividual()) {
                    return a.getNome().compareTo(b.getNome());
                } else {
                    return Double.compare(b.getResultadoIndividual(), a.getResultadoIndividual());
                }
            }
        });
    }
}