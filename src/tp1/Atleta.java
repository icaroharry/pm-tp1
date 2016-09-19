package tp1;

import java.util.Collection; 
import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Atleta {
	private int id = 0;
	private int idPais = 0;
	private int idEsporte = 0;
	private String nome = null;
	private double result[] = null;
	
	private String resultTemp[] = null;// guardar� temporariamente a string que ser� dividida em partes;
	private String texto[]; //guardar� temporariamente o texto antes de passar para vari�veis
	
	private double resultadoIndividual = 0;

	public Atleta(int id, int idPais, int idEsporte, String nome, double result[]) {
		this.id = id;
		this.idPais = idPais;
		this.idEsporte = idEsporte;
		this.nome = nome;
		this.result = result;
	}
	
	public int getId(){
		return this.id;
	}
	public int getIdPais(){
		return this.idPais;
	}
	public int getIdEsporte(){
		return this.idEsporte;
	}
	public String getNome(){
		return this.nome;
	}
	public double[] getResult(){
		return this.result;
	}
	
	
	
	public void setResultadoIndividual(double resultadoIndividual){
		this.resultadoIndividual = resultadoIndividual;
	}
	public double getResultadoIndividual(){
		return resultadoIndividual;
	}
	
}
