package com.qintess.model;

public class Resultado {
	private String Nome;
	private double valor;
	
	
	public Resultado(String nome) {
		Nome = nome;
	}
	public Resultado(String nome, double valor) {
		Nome = nome;
		this.valor = valor;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public double getValor() {
		return valor;
	}
	public void somaValor(double valor) {
		this.valor += valor;
	}
}
