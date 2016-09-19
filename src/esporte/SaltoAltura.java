package esporte;

import tp1.Atleta;

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

    private double calculaResultadoIndividual(double[] result) {
        double maior = 0;
        for(int i = 0; i < 5; i++) {
            if(result[i] > maior) {
                maior = result[i];
            }
        }
        return maior;
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