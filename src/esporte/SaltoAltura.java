package esporte;

import atleta.Atleta;

import java.util.Collections;
import java.util.Comparator;

public class SaltoAltura extends Esporte {
    public SaltoAltura() {
        super();
    }

    public SaltoAltura(int id, String nome) {
        super(id, nome);
    }

    public SaltoAltura(int id) {
        super(id);
        this.setNome("Salto em altura");
    }

    /**
     * Sobrescrita do método calculaResultadoIndividual
     * No caso dos saltos, o resultado individual é calculado
     * pela maior altura de 5 saltos
     */
    @Override
    protected double calculaResultadoIndividual(double[] result) {
        double maior = 0;
        for(int i = 0; i < 5; i++) {
            if(result[i] > maior) {
                maior = result[i];
            }
        }
        return maior;
    }

    /**
     * Sobrescrita do método determinaVencedor
     * No caso do salto, é feito uma ordenação de forma decrescente (do maior para o menor tempo)
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