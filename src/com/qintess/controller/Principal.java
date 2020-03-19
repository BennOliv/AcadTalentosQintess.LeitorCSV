package com.qintess.controller;

import java.util.ArrayList;

import com.qintess.model.DadoMercado;
import com.qintess.model.Operacao;
import com.qintess.model.Resultado;
import com.qintess.util.Configura;

public class Principal {
	public static void main(String[] args) {
		
		long tempo = System.currentTimeMillis();
		
		ArrayList<Operacao> listaOps = new ArrayList<>();
		ArrayList<DadoMercado> listaDds = new ArrayList<>();
		ArrayList<Resultado> listaResults = new ArrayList<>();
		
		String pathOp = "";
		String pathDd = "";
		String pathSaida = "";
		
		Configura.geraOps(listaOps, pathOp);
		Configura.geraDds(listaDds, pathDd);
		Configura.geraValores(listaOps, listaDds, listaResults);
		Configura.geraCsv(listaResults, pathSaida);
		
		System.out.println("Tempo de execução: " + (tempo = System.currentTimeMillis() - tempo) + "ms.");
	}
}