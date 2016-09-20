package atleta;

public class Atleta {
	// Atributos
    private int id = 0;
	private int idPais = 0;
	private int idEsporte = 0;
	private String nome = null;
	private double resultados[] = null;
	private double resultadoIndividual = 0;

	// Construtores
    public Atleta(int id, int idPais, int idEsporte, String nome, double result[]) {
		this.id = id;
		this.idPais = idPais;
		this.idEsporte = idEsporte;
		this.nome = nome;
		this.resultados = result;
	}

	// Getters e setters
	public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getIdPais() {
        return idPais;
    }
    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public int getIdEsporte() {
        return idEsporte;
    }
    public void setIdEsporte(int idEsporte) {
        this.idEsporte = idEsporte;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public double[] getResultados() {
        return resultados;
    }
    public void setResultados(double[] resultados) {
        this.resultados = resultados;
    }

    public double getResultadoIndividual() {
        return resultadoIndividual;
    }
    public void setResultadoIndividual(double resultadoIndividual) {
        this.resultadoIndividual = resultadoIndividual;
    }
}
