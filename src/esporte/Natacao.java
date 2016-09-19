package esporte;

import tp1.Atleta;

import java.util.Collections;
import java.util.Comparator;

public class Natacao extends Esporte {
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

    private double calculaResultadoIndividual(double[] result) {
        double menor = 1000;
        for(int i = 0; i < 3; i++) {
            if(result[i] < menor) {
                menor = result[i];
            }
        }
        return menor;
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
                    return Double.compare(a.getResultadoIndividual(), b.getResultadoIndividual());
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
        System.out.printf("TESTE Nat + %f", a.getResultadoIndividual());
        super.novoAtleta(a);
    }
}