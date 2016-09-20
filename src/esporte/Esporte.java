package esporte;

import java.util.ArrayList;
import java.util.List;

import atleta.Atleta;
import pais.Pais;

public abstract class Esporte {
	// Atributos
	private int id = 0;
	private String nome = null;
	protected List<Atleta> atletas = new ArrayList<Atleta>();

	// Construtores
	public Esporte() {}

	public Esporte(int id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Esporte(int id) {
		this.id = id;
	}

	// Getters and setters
	public String getNome(){
		return this.nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getId(){
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
	}

    public List<Atleta> getAtletas() {
        return atletas;
    }
    public void setAtletas(List<Atleta> atletas) {
        this.atletas = atletas;
    }

    // Métodos

	/**
	 * Método abstrato para determinar o vencedor do esporte em questão.
	 * Deve ser sobrescrito pelas classes filhas.
	 *
	 * Os vencedores são calculados da seguinte forma:
	 * Após todos os atletas e seus resultados individuais terem sido cadastrados no esporte,
	 * o vetor de atletas é ordenado de forma crescente ou decrescente, dependendo do
	 * esporte. Caso haja empate no resultado, o desempate é feito pela ordem alfabética do
	 * nome dos atletas.
	 */
	public abstract void determinaVencedor();

	/**
	 * Método que calcula o resultado individual de um atleta no esporte.
	 * Para cada esporte, é utilizado um método diferente refletido pela forma como o esporte
	 * funciona.
	 *
	 * Por exemplo: na corrida o resultado individual do atleta é obtido pelo menor tempo de 3 corridas.
	 * @param double[] result - vetor contendo a série de resultados ou notas do atleta
	 * @return double - resultado individual
	 */
	protected abstract double calculaResultadoIndividual(double[] result);

	/**
	 * Método que adiciona um novo atleta na lista de atletas do esporte
	 * @param Atleta a - novo atleta a ser adicionado
	 */
	public void novoAtleta(Atleta a) {
		double resultadoIndividual = calculaResultadoIndividual(a.getResultados());
		a.setResultadoIndividual(resultadoIndividual);
		atletas.add(a);
	}

	/**
	 * Método que deve ser chamado após a determinação dos vencedores para distribuir as medalhas para
	 * os países na lista fornecida
	 * @param List<pais> paises - lista de países concorrendo medalhas no presente esporte
	 */
	public void distribuiMedalhas(List<Pais> paises) {
        for(int i = 0; i < paises.size(); i++) {
            if(paises.get(i).getId() == atletas.get(0).getIdPais()) {
                paises.get(i).novaMedalhaOuro();
            }
            if(paises.get(i).getId() == atletas.get(1).getIdPais()) {
                paises.get(i).novaMedalhaPrata();
            }
            if(paises.get(i).getId() == atletas.get(2).getIdPais()) {
                paises.get(i).novaMedalhaBronze();
            }
        }
    }
}