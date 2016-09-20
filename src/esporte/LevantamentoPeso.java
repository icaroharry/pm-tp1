package esporte;

import atleta.Atleta;

import java.util.Collections;
import java.util.Comparator;

public class LevantamentoPeso extends Esporte {
    // Construtores
    public LevantamentoPeso() {
        super();
    }

    public LevantamentoPeso(int id, String nome) {
        super(id, nome);
    }

    public LevantamentoPeso(int id) {
        super(id);
        this.setNome("Levantamento de peso");
    }

    // Métodos

    /**
     * Sobrescrita do método calculaResultadoIndividual
     * No caso do levantamento de pesos, o resultado individual é calculado
     * pela soma do peso de 5 levantamentos
     */
    @Override
    protected double calculaResultadoIndividual(double[] result) {
        double soma = 0;
        for(int i = 0; i < 5; i++) {
            soma += result[i];
        }
        return soma;
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