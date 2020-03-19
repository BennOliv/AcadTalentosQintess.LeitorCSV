package com.qintess.model;

public class DadoMercado {
	private int id, quant;
	private double preco;
	
	public DadoMercado(int id, int quant, double preco) {
		this.id = id;
		this.quant = quant;
		this.preco = preco;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	
	
}
