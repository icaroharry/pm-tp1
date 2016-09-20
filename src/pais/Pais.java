package pais;

public class Pais {
    // Atributos
    private int id;
    private String nome;
    private int medalhasOuro = 0;
    private int medalhasPrata = 0;
    private int medalhasBronze = 0;

    // Construtores
    public Pais(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Pais(int id, String nome, int medalhasOuro, int medalhasPrata, int medalhasBronze) {
        this.id = id;
        this.nome = nome;
        this.medalhasOuro = medalhasOuro;
        this.medalhasPrata = medalhasPrata;
        this.medalhasBronze = medalhasBronze;
    }

    // Getters e setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMedalhasOuro() {
        return medalhasOuro;
    }
    public void setMedalhasOuro(int medalhasOuro) {
        this.medalhasOuro = medalhasOuro;
    }

    public int getMedalhasPrata() {
        return medalhasPrata;
    }
    public void setMedalhasPrata(int medalhasPrata) {
        this.medalhasPrata = medalhasPrata;
    }

    public int getMedalhasBronze() {
        return medalhasBronze;
    }
    public void setMedalhasBronze(int medalhasBronze) {
        this.medalhasBronze = medalhasBronze;
    }

    // Métodos

    /**
     * Método que acrescenta uma medalha de ouro para o país corrente.
     */
    public void novaMedalhaOuro() {
        this.medalhasOuro++;
    }

    /**
     * Método que acrescenta uma medalha de prata para o país corrente.
     */
    public void novaMedalhaPrata() {
        this.medalhasPrata++;
    }

    /**
     * Método que acrescenta uma medalha de bronze para o país corrente.
     */
    public void novaMedalhaBronze() {
        this.medalhasBronze++;
    }
}
