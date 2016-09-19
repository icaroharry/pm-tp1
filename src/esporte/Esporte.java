package esporte;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import tp1.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public abstract class Esporte {
	private int id = 0;
	private String nome = null;
	protected List<Atleta> atletas = new ArrayList<Atleta>();

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
	public abstract void determinaVencedor();

	public void novoAtleta(Atleta a) {
		atletas.add(a);
	}

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
