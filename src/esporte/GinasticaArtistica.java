package esporte;

import tp1.Atleta;

import java.util.Collections;
import java.util.Comparator;

public class GinasticaArtistica extends Esporte {
    public GinasticaArtistica() {
        super();
    }

    public GinasticaArtistica(int id, String nome) {
        super(id, nome);
    }

    public GinasticaArtistica(int id) {
        super(id);
        this.setNome("Ginástica Artística");
    }

    private double calculaResultadoIndividual(double[] result) {
        double media = 0;
        for(int i = 0; i < 4; i++) {
            media += result[i];
        }
        return media/4;
    }

    @Override
    public void determinaVencedor() {
        // Sorting
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
        for(int i = 0; i < atletas.size(); i++) {
            System.out.print(atletas.get(i).getResultadoIndividual());
            System.out.printf("\n");
        }
    }

    @Override
    public void novoAtleta(Atleta a) {
        double resultadoIndividual = calculaResultadoIndividual(a.getResult());
        a.setResultadoIndividual(resultadoIndividual);
        System.out.printf("TESTE + %f\n", a.getResultadoIndividual());
        super.novoAtleta(a);
    }
}