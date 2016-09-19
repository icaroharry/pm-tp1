package tp1;


public class Pais {
    private int id;
    private String nome;
    private int medalhasOuro = 0;
    private int medalhasPrata = 0;
    private int medalhasBronze = 0;

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

    public void novaMedalhaOuro() {
        this.medalhasOuro++;
    }

    public void novaMedalhaPrata() {
        this.medalhasPrata++;
    }

    public void novaMedalhaBronze() {
        this.medalhasBronze++;
    }
}
