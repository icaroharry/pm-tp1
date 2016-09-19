package esporte;

import tp1.Atleta;

import java.util.Collections;
import java.util.Comparator;

public class LevantamentoPeso extends Esporte {
    public LevantamentoPeso() {
        super();
    }

    public LevantamentoPeso(int id, String nome) {
        super(id, nome);
    }

    public LevantamentoPeso(int id) {
        super(id);
        this.setNome("Levantamento de Peso");
    }

    private double calculaResultadoIndividual(double[] result) {
        double soma = 0;
        for(int i = 0; i < 5; i++) {
            soma += result[i];
        }
        return soma;
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
        System.out.printf("TESTE + %f", a.getResultadoIndividual());
        super.novoAtleta(a);
    }
}