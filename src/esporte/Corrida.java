package esporte;

import atleta.Atleta;

import java.util.Collections;
import java.util.Comparator;

public class Corrida extends Esporte {
    // Construtores
    public Corrida() {
        super();
    }

    public Corrida(int id, String nome) {
        super(id, nome);
    }

    public Corrida(int id) {
        super(id);
        this.setNome("Corrida");
    }

    //Métodos

    /**
     * Sobrescrita do método calculaResultadoIndividual
     * No caso da corrida, o resultado individual é calculado pelo menor tempo em 3 corridas do atleta
     */
    @Override
    protected double calculaResultadoIndividual(double[] result) {
        double menor = 1000;
        for(int i = 0; i < 3; i++) {
            if(result[i] < menor) {
                menor = result[i];
            }
        }
        return menor;
    }

    /**
     * Sobrescrita do método determinaVencedor
     * No caso da corrida, é feito uma ordenação de forma crescente (do menor para o maior tempo)
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
                    return Double.compare(a.getResultadoIndividual(), b.getResultadoIndividual());
                }
            }
        });
    }
}