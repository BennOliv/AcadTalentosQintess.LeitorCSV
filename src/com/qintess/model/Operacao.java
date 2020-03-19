package com.qintess.model;

public class Operacao {
	private String nome;
	private int id;
	private double quant, valor;
	private long contDias;
	
	public Operacao(String nome, int id, double quant, long contDias) {
		super();
		this.nome = nome;
		this.id = id;
		this.quant = quant;
		this.contDias = contDias;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getQuant() {
		return quant;
	}
	public void setQuant(double quant) {
		this.quant = quant;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public long getContDias() {
		return contDias;
	}
	public void setContDias(long contDias) {
		this.contDias = contDias;
	}
}
