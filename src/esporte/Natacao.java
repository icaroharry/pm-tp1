package esporte;

import atleta.Atleta;

import java.util.Collections;
import java.util.Comparator;

public class Natacao extends Esporte {
    // Construtores
    public Natacao() {
        super();
    }

    public Natacao(int id, String nome) {
        super(id, nome);
    }

    public Natacao(int id) {
        super(id);
        this.setNome("Natação");
    }

    // Métodos

    /**
     * Sobrescrita do método calculaResultadoIndividual
     * No caso da natação, o resultado individual é calculado
     * pelo menor tempo de 3 baterias
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
     * No caso da natação, é feito uma ordenação de forma crescente (do menor para o maior tempo)
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